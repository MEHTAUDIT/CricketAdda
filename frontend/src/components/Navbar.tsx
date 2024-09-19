"use client"

import * as React from "react"


import { cn } from "@/lib/utils"

import {
  NavigationMenu,
  NavigationMenuContent,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
  NavigationMenuTrigger,
  navigationMenuTriggerStyle,
} from "@/components/ui/navigation-menu"
import { Link } from "react-router-dom"
import {  useSelector } from "react-redux"
// import toast from "react-hot-toast"
import LoginButton from "./auth/LoginButton"
import Logout from "./auth/Logout"


const components: { title: string; href: string; description: string }[] = [
  {
    title: "View Tournaments",
    href: "/tournaments",
    description:
      "View all the tournaments that are currently running or have been completed.",
  },

  {
    title: "Create Tournament",
    href: "/tournaments/new",
    description:
      "Create a new tournament and invite your friends to participate.",
  },
  {
    title: "All Players",
    href: "/players",
    description:
      "All the players that have participated in the tournaments are listed here.",
  },
  {
    title : "Create Team",
    href : "/teams/new",
    description : "Create a new team and add players to your team."
  }
  
  
]

export function Navbar() {

  const user = useSelector((state : any) => state.user.user) || null;

  return (
    <div className="border-b p-2 shadow-md flex justify-around items-center">

   
    <NavigationMenu>
      <NavigationMenuList>
        <NavigationMenuItem>
          <Link className="flex justify-center items-center" to="/">
            <img src="/logo.png" alt="" className="h-14" />
            <h1 className="text-2xl font-bold ml-2">CricketAdda</h1>

          </Link>
          
        </NavigationMenuItem>
        <NavigationMenuItem>
          <NavigationMenuTrigger>Explore</NavigationMenuTrigger>
          <NavigationMenuContent>
            <ul className="grid w-[400px] gap-3 p-4 md:w-[500px] md:grid-cols-2 lg:w-[600px] ">
              {components.map((component) => (
                <ListItem
                  key={component.title}
                  title={component.title}
                  href={component.href}
                  className={""}
                >
                  {component.description}
                </ListItem>
              ))}
            </ul>
          </NavigationMenuContent>
        </NavigationMenuItem>
        <NavigationMenuItem>
          <Link to="/about"  >
            <NavigationMenuLink className={navigationMenuTriggerStyle()}>
              About Us
            </NavigationMenuLink>
          </Link>
        </NavigationMenuItem>
      </NavigationMenuList>
    </NavigationMenu>

      {user? <div>
        {/* <Button className="ml-auto " variant={"outline"}>{user.username}</Button>
        <Button className="ml-2" variant={"outline"} onClick={handleLogout}>Logout</Button> */}
        <Logout/>
        </div> : ""}
      { !user    &&
        // <Button className="ml-auto"><Link to="/login">Login</Link></Button>
        <LoginButton/>
      }

    </div>
  )

}

const ListItem = React.forwardRef(
  ({ className, title, children, href, ...rest }: { className: string; title: string; children: React.ReactNode; href: string; }, ref) => {
    return (
      <li>
        <Link
          to={href}
          ref={ref as React.LegacyRef<HTMLAnchorElement>}
          className={cn(
            "block select-none space-y-1 rounded-md p-3 leading-none no-underline outline-none transition-colors hover:bg-accent hover:text-accent-foreground focus:bg-accent focus:text-accent-foreground",
            className
          )}
          {...rest}
        >
          <div className="text-sm font-medium leading-none">{title}</div>
          <p className="line-clamp-2 text-sm leading-snug text-muted-foreground">
            {children}
          </p>
        </Link>
      </li>
    );
  }
);
ListItem.displayName = "ListItem";
