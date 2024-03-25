

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
import Login from './components/auth/Login';
import { useEffect  } from 'react';
import CreateTeam from './components/team/CreateTeam';
// import { useSelector } from 'react-redux';




function App() {


  // const user = useSelector((state : any) => state.user.user) || {};

  useEffect(() => {
    document.title = 'CricketAdda'

    findUser();

    
  } , [])


  const findUser = async () => {  
    
    const cookies = document.cookie.split(';');
    // const jwtToken = cookies.find(cookie => cookie.startsWith('jwtToken=')).split('=')[1];
    // i want to find cookie named jwtToken
    // console.log(jwtToken);
    // print all cookies
    console.log(cookies);
    const jwtToken = cookies.find(cookie => cookie.startsWith(' jwtToken='));
    console.log(jwtToken?.split('=')[1]);

    
   
  }

  
  

  return (
    <div className=' font-secondary'>
      <Router>

        
        <Navbar/>

       
        <Toaster/>
        <div className='flex min-h-screen flex-col items-center mt-10'>
          <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/tournaments" element={<Tournaments/>} />
            <Route path="/tournaments/:id" element={<TournamentPage/>} />
            <Route path="/tournaments/new" element={<AddTournament/>} />
            <Route path="/players" element={<Players/>} />
            <Route path='/about' element={<About/>}></Route>
            <Route path='/login' element={<Login/>}></Route>
            <Route path='/teams/new' element={<CreateTeam/>}></Route>

          </Routes>
        </div>

     
      </Router>

    </div>
  )
}

export default App
