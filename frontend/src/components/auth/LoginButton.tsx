import { Button } from '../ui/button';
import React from 'react'
import { GoogleIcon } from './GoogleIcon';

export function GoogleButton(props : any& React.ComponentPropsWithoutRef<'button'>) {
    return <Button leftSection={<GoogleIcon />} variant="default" {...props} />;
}

export default function LoginButton() {
  return (
    <a href='http://localhost:8080/oauth2/authorization/google'>

       <Button>
        <GoogleIcon className='w-10 h-10 mr-2'/>
        <span>Continue with Google</span>
       </Button>

    </a>
  )
}
