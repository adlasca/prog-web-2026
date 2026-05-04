import React from "react";

function Hola(props: {name:string, age:number}) {

    const [count, setCount]=React.useState(0);
    const click =()=>{
       // alert("Hello World!");
        //alert(`Hola ${props.name}`);
        setCount(count+1)
    }
    return (
        <>
            <h1>HEllo {props.name} with {props.age}</h1>
            <b>Ejemplo de componente De React</b>
            <button onClick={click}>Tocame</button>
            <h2>{count}</h2>
        </>
    )
}

export default Hola;