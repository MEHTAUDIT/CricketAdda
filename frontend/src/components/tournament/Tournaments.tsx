import  {useEffect , useState} from 'react'
import axios from 'axios'
import { Card } from '../ui/card'
import { useNavigate } from 'react-router-dom'




export default function Tournaments() {
    const navigate = useNavigate()

    useEffect(() => {
        document.title = 'All Tournaments'
        fetchTournaments()
    }   , [])

    const fetchTournaments = async () => {
        const response = await axios.get('http://localhost:8080/api/tournaments')
        setTournaments(response.data)
        console.log(tournaments)
    }


    const [tournaments , setTournaments] = useState<any []>([])


    
  return (
    <div>

        <h1 className='text-4xl'>Tournaments</h1>

        <div className='grid grid-cols-3 gap-4 mt-5'>
            {tournaments.map((tournament ,  i) => (
                <Card key={i} className='bg-gray-100 p-4 rounded-lg cursor-pointer space-y-2' onClick={()=> navigate(`/tournaments/${tournament.id}`)}>
                    <h2 className='text-xl'>{tournament.tournament_name}</h2>
                    <p>Format : {tournament.tournament_type}</p>
                    <p>Date : {tournament.start_date}</p>

                </Card>
                

            ))}
            

        </div>




    </div>
  )
}
