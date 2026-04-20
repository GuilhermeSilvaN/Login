import { useEffect, useState } from "react";
import api from "../service/api";

export default function Home(){
    const [products, setProducts] = useState([]);

    useEffect(()=>{
        async function fetchProducts(){
            try{
                const response = await api.get("/product/list");
                setProducts(response.data);
                
                console.log(response.data);

            } catch(error){
                console.log("error ao buscar produtos", error);
            }
        }

        fetchProducts();
    }, []);

    return (
        <div>
            <h2>Produtos</h2>

            {products.map((p, index) => (
                <p key={index}> code: {p.code}, name: {p.username}</p>
            ))}
        </div>
    )
}