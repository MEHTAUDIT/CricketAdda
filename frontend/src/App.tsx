

import './App.css'

import { Navbar } from './components/Navbar'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Tournaments from './components/tournament/Tournaments';
import Players from './components/players/Players';
import AddTournament from './components/tournament/AddTournament';
import { Toaster } from 'react-hot-toast';
import TournamentPage from './components/tournament/TournamentPage';

function App() {
  

  return (
    <div className=' font-secondary'>
      <Router>

        <Navbar/>
        <Toaster/>
        <div className='flex min-h-screen flex-col items-center mt-10'>
          <Routes>
            <Route path="/" element={<h1>Home</h1>} />
            <Route path="/tournaments" element={<Tournaments/>} />
            <Route path="/tournaments/:id" element={<TournamentPage/>} />
            <Route path="/tournaments/new" element={<AddTournament/>} />
            <Route path="/players" element={<Players/>} />
          </Routes>
        </div>

     
      </Router>

    </div>
  )
}

export default App
