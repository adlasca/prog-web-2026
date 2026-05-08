import React, { useState } from "react";
import {useNavigate} from "react-router-dom";

function Form1(){
    const [name, setName] = useState('')

    const navigate = useNavigate();

    const handleSubmit = (e: React.SyntheticEvent<HTMLFormElement>): void => {

        e.preventDefault()
        navigate('/form2',{state:{message:name}});
    }

    return (
        <form onSubmit={handleSubmit}>
            <h2>Formulario 1</h2>
            Nombre:
            <input type="text" value={name}
            onChange={(e)=>setName(e.target.value)}
            />
            <input type="submit" value="Enviar" />
            <div>{name}</div>

        </form>
    )
}

export default Form1;