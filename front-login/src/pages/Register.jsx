import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../service/api";
import './Login.css'

export default function Register(){
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    function goToRegister(){
        navigate("/register");
    }
    function goToLogin(){
        navigate("/");
    }
    
    async function handleRegister(e){
        e.preventDefault();
        
        const user = {
            username,
            email,
            password,
        }
        
        console.log(user);
        
        if(!username.trim() || !email.trim() || !password.trim()){
            alert("preencha os campos baitola!")
            return;
        }

        const isActive = true;

        try{
            const response = await api.post("/login/register", {
                username, email, password, isActive
            });
            console.log(response);
            
            
            navigate("/");
            
        } catch(error){
            console.log("error no login", error);
            alert("Login invalido");
        }
    }
    
    return (
        <div className="container">
            <div className="sings">
                <button type="button" className="btn-log" onClick={goToLogin}>LOGIN</button>
                <button type="button" className="btn-log" onClick={goToRegister}>REGISTRAR</button>
            </div>

            <h2>Login</h2>
            <form onSubmit={handleRegister}>
                <input
                type="text"
                placeholder="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                />

                <input
                type="email"
                placeholder="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                />

                <input
                type="text"
                placeholder="senha"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                />

                <button type="submit">registrar</button>
            </form>
        </div>
    )
}