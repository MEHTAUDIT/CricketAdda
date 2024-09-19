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
import { useSelector } from "react-redux";

export default function EditPlayer(props: any) {

  const user = useSelector((state: any) => state.user.user) || null;

  

  const [teams , setTeams] = useState<any[]>([]);

  useEffect(() => {
    
    fetchTeams();
  } , []);

  const fetchTeams = async () => {
    console.log("fetching teams");
    const response = await axios.get(
      `http://localhost:8080/api/teams`,  {withCredentials : true}
    );
    setTeams(response.data);
   
    
   
  }

  const handleSubmit = async ()=>{
   

    try {
      await axios.post( `http://localhost:8080/api/player` , player , 
        {
          withCredentials : true,
        }
      )


      if(teamId !=0){
        await axios.get( `http://localhost:8080/api/team/${teamId}/addplayer/${player.id}`, 
        
        {
          headers : {
            Authorization : `Bearer ${user?.jwtToken}`
          }
        }
        )

      }

      toast.success("Player details updated successfully")
    }
    catch(err : any){
      toast.error("Failed to update player details")
    }

   



  }

  const [ player , setPlayer ] = useState<any>(props.player);

  const [teamId , setTeamId] = useState(0);




  return (
    <div>
      <AlertDialog>
        <AlertDialogTrigger asChild>
            <Button variant={"secondary"}>{props.text}</Button>
        </AlertDialogTrigger>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>Edit Player Details</AlertDialogTitle>
            <AlertDialogDescription>
              You can change the player name, role and team.
            </AlertDialogDescription>
          </AlertDialogHeader>

      
          <div className="space-y-8">
            <div className="grid w-full items-center gap-4">
            <div className="flex flex-col space-y-1.5">
                <Label>Player Name</Label>
                <input
                  type="text"
                  value={player.name}
                  onChange={(e) => setPlayer({ ...player, name: e.target.value })}
                  className="border p-1"
                />
              </div>
              <div className="flex flex-col space-y-1.5">
                <Label>Playing Role</Label>
                <input
                  type="text"
                  value={player.role}
                  onChange={(e) => setPlayer({ ...player, role: e.target.value })}
                  className="border p-1"
                />
              </div>
              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="name">Select a team</Label>
              
                <Select  onValueChange={(target)=> setTeamId(Number(target)) }>
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
            <AlertDialogAction onClick={handleSubmit}>Update</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </div>
  );
}
