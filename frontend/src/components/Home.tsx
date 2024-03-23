

export default function Home() {
  return (
    <div>

        <div className="flex flex-col justify-center items-center space-y-10">
            <div className="flex justify-center items-center">
                <img src="/cricket2.jpeg" alt="" className="h-60 rounded-lg shadow-xl border border-gray-400"/>
                <h2 className="px-10 py-5 flex flex-col space-y-1.5">
                <span className="font-bold text-4xl">CricketAdda</span>
                <span className="font-medium text-lg"> Your Ultimate Cricket Companion!</span>
 
                </h2>
            </div>
            <div className="flex justify-center items-center">
                <ul className="px-10 py-5 flex flex-col space-y-1.5 list-disc text-left">
                <li className="font-bold text-md">Easy hosting of tournaments</li>
                <li className="font-bold text-md">Efficient team and players management</li>
                <li className="font-bold text-md">Match tracking with updates</li>



                </ul>
                <img src="/cricket3.jpeg" alt="" className="h-60 rounded-lg shadow-xl border border-gray-400"/>
            </div>
        </div>


    </div>
  )
}
