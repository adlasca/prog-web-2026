import { useState } from "react"

import HolaMundo2 from "./HolaMundo2";

export function Contador(){

    const [contador,setContador]= useState(0);

    const handleUp=()=>{
        setContador(contador+1);
    }

    const handleDown=()=>{
        setContador(contador-1);
    }

    return (
        <>
            <div>Valor: {contador}</div>
            <br/>
            <button onClick={handleUp}>+</button>
            <button onClick={handleDown}>-</button>
            <HolaMundo2 name="Pepe" age={contador}/>
        </>
    )
}