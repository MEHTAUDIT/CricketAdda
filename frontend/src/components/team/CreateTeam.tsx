import { useState } from "react";

import { Input } from "@/components/ui/input";
import axios from "axios";
import { Button } from "../ui/button";
import { Label } from "../ui/label";
import toast from "react-hot-toast";
import { useDispatch, useSelector } from "react-redux";

import { useNavigate } from "react-router-dom";

export default function CreateTeam() {
 

  const navigate = useNavigate();

  const [ teamForm, setTeamForm ] = useState({
    team_name: "",
  });

  const user = useSelector((state: any) => state.user.user) || null;
  


  const handleSubmit = async (e: any) => {
    e.preventDefault();
    
    try {
      console.log("team created" + user?.jwtToken);
      console.log(teamForm  )
      await axios.post(
        "http://localhost:8080/api/team", teamForm, 
        {
          headers: {
            Authorization: `Bearer ${user?.jwtToken}`,
          },
          withCredentials: true,
        
        } );  
      toast.success("Team Created , you can now add players to the team");
      navigate("/players")

      
    }
    catch (err : any) {
      toast.error("Failed to create team, check you have authourization to create team");
    }

  };

  const handleChange = (e: any) => {
    setTeamForm({
      ...teamForm,
      [e.target.name]: e.target.value,
    });
  }
 



  return (
    <div>
      <h1 className="text-3xl mb-10">Create New Team</h1>

      
      <div>
        <div className="grid w-full items-center gap-4">
          <div className="flex flex-col space-y-1.5">
            <Label htmlFor="team_name">Team Name</Label>
            <Input
              id="team_name"
              placeholder="Team Name"
              name="team_name"
              onChange={handleChange}
            />
          </div>
          
        </div>
        <Button onClick={handleSubmit}>Create Team</Button>
      </div>
    </div>
  );
}
