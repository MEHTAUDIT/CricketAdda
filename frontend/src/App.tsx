import { useState } from 'react'

import './App.css'

import { Navbar } from './components/Navbar'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className=''>
      <Navbar/>

      <div className='flex flex-col justify-center items-center space-y-10 m-10 p-20'>

        <div className='flex justify-center items-center'>
          <img src="/cricket2.jpeg" alt="" className='w-[400px] rounded-2xl'/>
          <p className=' text-center text-4xl'>CricketAdda</p>

        </div>
        
        <div className='flex justify-center items-center'>
        <p className='p-10'>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Labore, culpa exercitationem repellendus impedit in a mollitia sunt blanditiis aliquid id.</p>
        <img src="/cricket3.jpeg" alt="" className='w-2/5 rounded-2xl'/>
        </div>

      </div>
    </div>
  )
}

export default App
