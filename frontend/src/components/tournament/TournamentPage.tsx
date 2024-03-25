import  { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Card } from "../ui/card";
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableRow,
} from "@/components/ui/table";
import AddMatch from "../match/AddMatch";
import AddTeam from "../team/AddTeam";
// import { useSelector } from "react-redux";

export default function TournamentPage() {
  const { id } = useParams();

  
  useEffect(() => {
  
    fetchTournament();
    fetchMatches();
    fetchTeams();
  }, []);

  const fetchTournament = async () => {

    const response = await axios.get(
      `http://localhost:8080/api/tournament/${id}` ,
      {
        headers: {
          Authorization: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJLcmlzIiwiaWF0IjoxNzExMzA0NzIwLCJleHAiOjE3MTEzOTExMjB9.Q4ePWxlgImAouYx7QhoQpIvwQLY3_BxK2ub-fcUtRHc`,
        },
      }
    );
    setTournament(response.data);
  };

  const fetchMatches = async () => {
    console.log("fetching matches");
    const response = await axios.get(
      `http://localhost:8080/api/tournament/${id}/matches`
    );
    setMatches(response.data);
  }

  const fetchTeams = async () => {
    console.log("fetching teams");
    const response = await axios.get(
      `http://localhost:8080/api/tournament/${id}/teams`
    );
    setTeams(response.data);
  }

  const [tournament, setTournament] = useState<any>();

  const [matches, setMatches] = useState<any[]>([]);

  const [teams , setTeams] = useState<any[]>([]);



  return (
    <div>
      <h1 className="text-2xl ">Matches of <span className=" font-medium">{ tournament?.tournament_name}</span></h1>



        <div className="grid grid-cols-2 gap-4 my-5">
            {matches.map((match, i) => (
            <Card key={i} className="bg-gray-100 p-4 rounded-lg cursor-pointer space-y-2">
                <h2 className="text-xl">{match.team1.team_name} vs {match.team2.team_name}</h2>
                <p>Status : {match.match_status}</p>
                <p>Date : {match.match_date}</p>
            </Card>
            ))}
        </div>

        <AddMatch tournament_id={id} teams={teams}/>



        <h1 className="text-2xl mt-16">Teams of <span className=" font-medium">{ tournament?.tournament_name}</span></h1>

        <Table className="w-[800px] shadow-md mb-5">
       <TableCaption> All the teams participated in this tournament .</TableCaption>
        <TableHead>
          
        </TableHead>
        <TableBody>
            <TableRow className="text-lg font-semibold">
                <TableCell>Sr. No.</TableCell>
                <TableCell>Team Name</TableCell>
            </TableRow>
          
          {teams.map((team, i) => (
            <TableRow key={i} className="text-md">
              <TableCell>{i+1}</TableCell>

              <TableCell>{team.team_name}</TableCell>
              
            </TableRow>
          ))}
        </TableBody>
      </Table>

      <AddTeam tournament_id={id} />
    </div>
  );
}
