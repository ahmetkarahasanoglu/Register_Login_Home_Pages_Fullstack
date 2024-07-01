import { useState, useEffect } from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css'
import Signup from './pages/Signup'
import Login from './pages/Login'
import Home from './pages/Home/LandingPage.tsx'

function App() {
    const [isLogin, setIsLogin] = useState(false);

    useEffect(()=> {
        let token = localStorage.getItem("token");
        if(token)
            setIsLogin(true);
        else
            setIsLogin(false);
    }, [])

    return (
        <>
        <Router>
            <Routes>
                <Route path="/" element={ isLogin ? <Home /> : <Login />} /> 
                <Route path="/home" element={<Home />} />
                <Route path="/signup" element={<Signup />} />
                <Route path="/login" element={<Login />} />
            </Routes>
        </Router>
      
        </>
    )
}

export default App
