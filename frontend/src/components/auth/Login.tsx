import { useState } from "react";

import { Input } from "@/components/ui/input";
import axios from "axios";
import { Button } from "../ui/button";
import { Label } from "../ui/label";
import toast from "react-hot-toast";
import { useDispatch } from "react-redux";

import { useNavigate } from "react-router-dom";

export default function Login() {
  const [loginForm, setLoginForm] = useState({
    username: "",
    password: "",
  });
  
  const dispatch = useDispatch();
  const navigate = useNavigate();
  


  const handleSubmit = async (e: any) => {
    e.preventDefault();
    const response = await axios.post("http://127.0.0.1:8080/api/auth/login"  , loginForm , 
      {
        withCredentials: true
      }
    
    );

    if(response.data){
        toast.success('Login Successfull')
        // console.log(response.data)

       
        localStorage.setItem('jwtToken' , (response.data.jwtToken))

        
        
        dispatch({
            type: 'SET_USER',
            payload: response.data
        })
        navigate('/tournaments')

    }
    else{
        toast.error('Login Failed')
        dispatch({
            type: 'CLEAR_USER'
        })
    }

    



  };

    const handleChange = (e: any) => {
        setLoginForm({
        ...loginForm,
        [e.target.name]: e.target.value,
        });
    };



  return (
    <div>
      {/* <h1 className="text-3xl mb-10">Login</h1> */}

      
      <div>
        <div className="grid w-full items-center gap-4">
          <div className="flex flex-col space-y-1.5">
            <Label htmlFor="username">Username</Label>
            <Input
              id="username"
              placeholder="Username"
              name="username"
              onChange={handleChange}
            />
          </div>
          <div className="flex flex-col space-y-1.5">
            <Label htmlFor="password">Password</Label>
            <Input
              id="password"
              placeholder="Password"
              name="password"
              type="password"
              onChange={handleChange}
            />
          </div>
        </div>
        <Button onClick={handleSubmit} className="mt-4">Login</Button>
      </div>
    </div>
  );
}
