import { useState } from "react";
import { Button } from "../ui/button";
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogTrigger,
} from "../ui/alert-dialog";
import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
  } from "@/components/ui/select"
import { Input } from "../ui/input";
import { Label } from "../ui/label";
import axios from "axios";

export default function AddMatch(props: any) {
  const [matchForm, setMatchForm] = useState({
    team1: 0,
    team2: 0,
    match_date: "",
    tournament: props.tournament_id,
  });

  const handleChange = (e: any) => {
    setMatchForm({
      ...matchForm,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    const response = await axios.post(
      "http://localhost:8080/api/tournament/addmatch",
      matchForm
    );
    if (response.status === 200) {
      console.log("Match added successfully");
    } else if (response.status === 400) {
      console.log("Error adding match");
    }
    console.log(matchForm);

  };



  return (
    <div>
      <AlertDialog>
        <AlertDialogTrigger asChild>
          <Button>Add New Match</Button>
        </AlertDialogTrigger>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>New Match</AlertDialogTitle>
            <AlertDialogDescription>
              Fill proper details to add a new match . Add team in the tournament first for new match.
            </AlertDialogDescription>
          </AlertDialogHeader>

          <div className="space-y-8">
            <div className="grid w-full items-center gap-4">
              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="name">Team No.1</Label>
              
                <Select name="team1" onValueChange={handleChange}>
                  <SelectTrigger>
                    <SelectValue placeholder="Team" />
                  </SelectTrigger>
                  <SelectContent>
                    
                    {props.teams.map((team: any, i: number) => (
                        <SelectItem key={i} value={team.id}>{team.team_name}</SelectItem>
                    ))}
                  </SelectContent>
                </Select>
              </div>
              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="name">Team No.2</Label>
              
                <Select name="team2" onValueChange={handleChange}>
                  <SelectTrigger>
                    <SelectValue placeholder="Team" />
                  </SelectTrigger>
                  <SelectContent>
                    
                    {props.teams.map((team: any, i: number) => (
                        <SelectItem key={i} value={team.id}>{team.team_name}</SelectItem>
                    ))}
                  </SelectContent>
                </Select>
              </div>

              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="startdate">Match Date</Label>
                <Input
                  id="match_date"
                  placeholder="Starting Date"
                  name="match_date"
                  onChange={handleChange}
                />
              </div>
            </div>
          </div>

          <AlertDialogFooter>
            <AlertDialogCancel>Cancel</AlertDialogCancel>
            <AlertDialogAction onClick={handleSubmit}>Submit</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </div>
  );
}
