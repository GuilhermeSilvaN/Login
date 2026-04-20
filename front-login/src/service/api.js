import axios from 'axios'

const api = axios.create({
    baseURL : "http://localhost:8080"
}) 

//interceptor -> roda antes de cada requisicao;
api.interceptors.request.use((config)=>{
    const token = localStorage.getItem("token");

    if(token){
        config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
})

//isso evita ter que colocar o token manualmente em toda requisição;

export default api;