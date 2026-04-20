//import { useState } from 'react'
import Dashboard from './components/dashboard/Dashboard.jsx';
import ProfileUser from './components/perfil/ProfileUser.jsx'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './pages/Login.jsx';
import Register from './pages/Register.jsx';
import Home from './pages/Home.jsx';
import './style/global.css'

function App() {
  
  return (
    <>
      <BrowserRouter>
        
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/home" element={<Home/>}/>
        </Routes>

      </BrowserRouter>
    </>

  );
}

export default App
