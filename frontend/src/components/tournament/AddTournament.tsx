import { useState } from "react";

import { Input } from "@/components/ui/input";
import axios from "axios";
import { Button } from "../ui/button";
import { Label } from "../ui/label";
import toast from "react-hot-toast";

export default function () {
  const [form, setForm] = useState({
    tournament_name: " ",
    tournament_type: " ",
    start_date: " ",
  });

  const handleSubmit = async ( e : any) => {
    e.preventDefault()
    // console.log(form);
    const response = await axios.post('http://localhost:8080/api/tournament' , form)

    if(response.status === 200){
      toast.success('Tournament created successfully')
    }
    else if(response.status === 400){
      toast.error('Error creating tournament')
    }
  };

  const handleChange = (e: any) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div>
      <h1 className="text-3xl mb-10">Host new Tournament</h1>

      <div  className="space-y-8">
        <div className="grid w-full items-center gap-4">
          <div className="flex flex-col space-y-1.5">
            <Label htmlFor="name">Tournament Name</Label>
            <Input id="name" placeholder="Name of your tournament" name="tournament_name" onChange={handleChange} />
          </div>
          <div className="flex flex-col space-y-1.5">
            <Label htmlFor="format">Tournament Format</Label>
            <Input id="format" placeholder="T20 , T10 , ODI etc ..."  name="tournament_type" onChange={handleChange} />
          </div>

          <div className="flex flex-col space-y-1.5">
            <Label htmlFor="startdate">Tournament Format</Label>
            <Input id="startdate" placeholder="Starting Date"  name="start_date" onChange={handleChange} />
          </div>
        </div>
        <Button onClick={handleSubmit}>Submit</Button>
      </div>
    </div>
  );
}