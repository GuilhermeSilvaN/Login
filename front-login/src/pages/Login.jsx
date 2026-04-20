import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../service/api";
import './Login.css'

export default function Login(){
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    function goToRegister(){
        navigate("/register");
    }
    function goToLogin(){
        navigate("/");
    }

    async function handleLogin(e){
        e.preventDefault();

        console.log(email, password);
        
        if(!email.trim() || !password.trim()){
            alert("preencha os campos baitola!")
            return;
        }

        try{
            const response = await api.post("/login", {
                email, password
            });


            const token = response.data.token;

            //salva o token;
            localStorage.setItem("token", token);

            navigate("/home");
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
            <form onSubmit={handleLogin}>
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

                <button type="submit">Entrar</button>
            </form>
        </div>
    )
}