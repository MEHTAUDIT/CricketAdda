import { useEffect, useState } from "react";
import axios from "axios";
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableRow,
} from "@/components/ui/table";
import EditPlayer from "./EditPlayer";
import { Button } from "../ui/button";
import { useSelector } from "react-redux";
import toast from "react-hot-toast";

export default function Players() {
  useEffect(() => {
    document.title = "All Players";
    fetchTournaments();
  }, []);

  const fetchTournaments = async () => {
    const response = await axios.get("http://localhost:8080/api/players" ,  {
      withCredentials : true
    });
    setPlayers(response.data);
  };

  const deletePlayer = (id: any) => async () => {
    // console.log(id);
    // console.log(user.jwtToken)
    
    try {
      await axios.post(`http://localhost:8080/api/player/${id}` , 
      {
        headers : {
          Authorization : `Bearer ${user?.jwtToken}`
        },
        withCredentials: true,
      }
      
      );
      toast.success("Player Deleted");
      fetchTournaments();
    } catch (err: any) {
      toast.error("Failed to delete player");
      console.error(err);
    }
  }

  const user = useSelector((state: any) => state.user.user) || null;
  const [players, setPlayers] = useState<any[]>([]);

  const player = {
    name: "",
    role: "",
    team: "",
  };

  return (
    <div>
      <h1 className="text-4xl mb-4">All Players</h1>

      <EditPlayer player={player} text = {"Add New Player"}/>

      <Table className="w-[800px] shadow-md ">
        <TableCaption>All the players that have participated in the tournaments are listed here.</TableCaption>
        <TableHead>
          
        </TableHead>
        <TableBody>
            <TableRow className="text-lg font-semibold">
                <TableCell >Player Name</TableCell>
                <TableCell>Playing Role</TableCell>
                <TableCell >Player Team</TableCell>
            </TableRow>
          
          {players.map((player, i) => (
            <TableRow key={i} className="text-md">
              <TableCell>{player.name}</TableCell>
              <TableCell>{player.role}</TableCell>
              {/* <TableCell>{player.team}</TableCell> */}
              <TableCell>
                {player.team ? player.team.team_name : "-"}
              </TableCell>

              <TableCell>
                  <EditPlayer player={player} text={"Edit"}/>
              </TableCell>
              <TableCell>
                  <Button variant={"destructive"} onClick={deletePlayer(player.id)}>Delete</Button>
              </TableCell>


            </TableRow>
          ))}
        </TableBody>
      </Table>
      
    </div>
  );
}
