

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
// import { useSelector } from 'react-redux';




function App() {


  // const user = useSelector((state : any) => state.user.user) || {};

  useEffect(() => {
    document.title = 'CricketAdda'

    findUser();

    
  } , [])


  const findUser = async () => {  
    // const response = await axios.post('http://localhost:8080/auth/token' , document.cookie ,{
    //   withCredentials: true
    // })

    // console.log(response)
    // console.log(response)
    // let token = null;
    // const cookieString = document.cookie;
    // const cookies = cookieString.split("; ");
    // for (let i = 0; i < cookies.length; i++) {
    //   const cookie = cookies[i].split("=");
    //   if (cookie[0] === "jwtToken") {
    //     token = cookie[1];
    //     break;
    //   }
    // }

    // console.log(token)
    // if(token){
    //   setUser({
    //     token : token,

      
    //   })
    // }

    // setUser(response)
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

          </Routes>
        </div>

     
      </Router>

    </div>
  )
}

export default App
