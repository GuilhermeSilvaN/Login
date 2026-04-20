import { useEffect, useState } from "react"
//import { Navigate, useNavigate } from "react-router-dom";
import getPublicData from "../../service/UserService";

export default function Dashboard () {

    const [user, setUser] = useState("");

    //const navigate = useNavigate();

    useEffect(()=>{
        getPublicData()
            .then(response =>{
                setUser(response.data);
            })
            .catch(error=>{
                console.error("error: ", error)
            });
    }, []);


    return(
        <div>
            <div>
            <p>wtf</p>
            {
                <p>{user}</p>
            }

            </div>
        </div>
    )
}