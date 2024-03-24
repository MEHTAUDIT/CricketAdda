export default function About() {
  return (
    <div className="flex flex-col justify-center items-center max-w-2xl text-justify">
      <h1 className="text-3xl mb-5">About Us</h1>
      <p>
        Hey there, cricket enthusiasts! Welcome to CricketAdda, the ultimate hub
        for all things cricket! We're a team of friends who bonded over our love
        for the game during our fourth semester in college. Inspired by our
        shared passion, we decided to create something special to enhance your
        cricket experience.
      </p>

      <div className="p-4 bg-gray-100 rounded-md mt-4 w-full">
        <p className="font-bold">Frontend:</p>
        <ul className="list-disc pl-6">
          <li>React + Vite + TypeScript for lightning-fast performance</li>
          <li>Shadcn UI for sleek and intuitive designs</li>
        </ul>
      </div>

      <div className="p-4 bg-gray-100 rounded-md mt-4 w-full">
        <p className="font-bold">Backend:</p>
        <ul className="list-disc pl-6">
          <li>Spring Boot (Java) for robust backend development</li>
          <li>RESTful APIs for smooth communication</li>
          <li>spring-boot-security with JWT for secure authentication</li>
          <li>MySQL for efficient data storage and retrieval</li>
        </ul>
      </div>

      
      <div className="p-4 rounded-md w-full mt-2">
        
      <h2 className="font-bold text-lg">Created By:</h2>
        <ul className="list-disc pl-6">
          <li>Kris Patel</li>
          <li>Udit Mehta</li>
        </ul>
      </div>

      
    </div>
  );
}
