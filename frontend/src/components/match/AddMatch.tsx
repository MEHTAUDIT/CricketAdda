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
import toast from "react-hot-toast";

export default function AddMatch(props: any) {
  const [matchForm, setMatchForm] = useState({
    team1: 0,
    team2: 0,
    match_date : new Date().toISOString().slice(0, 10),
    tournament: props.tournament_id,
  });

  const handleChange = (e: any) => {
    setMatchForm({
      ...matchForm,
      [e.target.name]: e.target.value,
    });
    console.log(matchForm)
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    
    try{
      const response = await axios.post('http://localhost:8080/api/tournament/addmatch' , matchForm)
      console.log(response)
      toast.success('Match Created')
    }
    catch(err : any){
      console.log(err)
      toast.error("Failed to create match , check you have authourization to create match")
    }



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
              
                <Select name="team1" onValueChange={(target) => setMatchForm({ ...matchForm, team1: parseInt(target) })}>
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
              
                <Select name="team2" onValueChange={(target) => setMatchForm({ ...matchForm, team2: parseInt(target) })}>
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
