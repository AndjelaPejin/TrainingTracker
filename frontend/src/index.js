import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import SignIn from './App';
import { createBrowserRouter, NavLink, Outlet, RouterProvider } from "react-router-dom";
import MenuAppBar from './Homepage';
import SignUp from './Signup';


const router = createBrowserRouter([
  {
    path: "/",
    element: <SignIn/>
  },
  {
    path: "/homepage",
    element: <MenuAppBar/>,
  },
  { path: "/signup",
    element: <SignUp/>
  }
]);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
); 


