import  { useState , useEffect } from "react";
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

import { Label } from "../ui/label";
import axios from "axios";
import toast from "react-hot-toast";

export default function AddTeam(props: any) {
  // const [ teamForm, setTeamForm ] = useState({
  //   team_id : 0,
  //   team_name : "",
  // });

  // const handleChange = (e: any) => {
  //   setTeamForm({
  //     ...teamForm,
  //     [e.target.name]: e.target.value,
  //   });
  // };
  
  const handleSubmit = async (e: any) => {
    e.preventDefault();
    try {
      await axios.get(
        `http://localhost:8080/api/tournament/${props.tournament_id}/addteam/${teamId}`,

        {
          withCredentials: true,
        }

        
        

      );
      toast.success("Team Added to the tournament");

  
    }
    catch (err : any) {
      toast.error("Failed to add team, check you have authourization to add team");
    }
   

    
    

  };

  const [teams , setTeams] = useState<any[]>([]);

  useEffect(() => {
    
    fetchTeams();
  } , []);

  const fetchTeams = async () => {
    console.log("fetching teams");
    const response = await axios.get(
      `http://localhost:8080/api/teams`, {withCredentials : true}
    );
    setTeams(response.data);
   
    
   
  }

  const [teamId , setTeamId] = useState(0);




  return (
    <div>
      <AlertDialog>
        <AlertDialogTrigger asChild>
          <Button>Add Team</Button>
        </AlertDialogTrigger>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>Add Team</AlertDialogTitle>
            <AlertDialogDescription>
                Create a new team to add to the tournament
            </AlertDialogDescription>
          </AlertDialogHeader>

          <div className="space-y-8">
            <div className="grid w-full items-center gap-4">
              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="name">Select a team</Label>
              
                <Select name="team_name" onValueChange={(target)=> setTeamId(Number(target)) }>
                  <SelectTrigger>
                    <SelectValue placeholder="Team" />
                  </SelectTrigger>
                  <SelectContent>
                    
                    {teams.map((team: any, i: number) => (
                        <SelectItem key={i} value={team.id} >{team.team_name}</SelectItem>
                    ))}
                  </SelectContent>
                </Select>
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
