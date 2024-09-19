

import './App.css'

import { Navbar } from './components/Navbar'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Tournaments from './components/tournament/Tournaments';
import Players from './components/players/Players';
import AddTournament from './components/tournament/AddTournament';
import { Toaster } from 'react-hot-toast';
import TournamentPage from './components/tournament/TournamentPage';
import Home from './components/Home';
import About from './components/About';
import { useEffect  } from 'react';
import CreateTeam from './components/team/CreateTeam';
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios';






function App() {


  const {user} = useSelector((state : any) => state.user) || {};

  useEffect(() => {
    document.title = 'CricketAdda'

    loadUser();    
  } , [])
  
  const dispatch = useDispatch();


  

  const loadUser = async () => {

    try {
      const {data} = await axios.get("http://localhost:8080/api/user" , {withCredentials: true});
      if(data) {
        console.log(data);
        dispatch({type: "SET_USER", payload
        : data}); 
      }
    } catch (error) {
      console.error(error);
    }

  };

  let routes ;

  console.log(user);
  if(user){
    routes = (
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/tournaments" element={<Tournaments/>} />
        <Route path="/tournaments/:id" element={<TournamentPage/>} />
        <Route path="/tournaments/new" element={<AddTournament/>} />
        <Route path="/players" element={<Players/>} />
        <Route path='/about' element={<About/>}></Route>
        <Route path='/teams/new' element={<CreateTeam/>}></Route>
        <Route path='*' element={<Home/>}></Route>

      </Routes>
    )
  }
  else {

    routes = (
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path='/about' element={<About/>}></Route>
        <Route path="*" element={<Home/>}></Route>
      </Routes>
    )
  }

  return (
    <div className=' font-secondary'>
      <Router>

        
        <Navbar/>

       
        <Toaster/>
        <div className='flex min-h-screen flex-col items-center mt-10'>
          {routes}
        </div>

     
      </Router>

    </div>
  )
}

export default App
