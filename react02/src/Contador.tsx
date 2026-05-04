import {useEffect, useState} from "react"


export function Contador() {

    useEffect(() => {
            console.log("Component render")
            return () => {
                console.log("component dismount")
            }
        }
    )


    const [contador, setContador] = useState(0);

    useEffect(() => {
            console.log("contador cambiado :",{contador});
        console.log(`contador ${contador}`);
        }, [contador]
    )

    const handleUp = () => {
        setContador(contador + 1);
    }

    const handleDown = () => {
        setContador(contador - 1);
    }

    return (
        <>
            <div>Valor: {contador}</div>
            <br/>
            <button onClick={handleUp}>+</button>
            <button onClick={handleDown}>-</button>
        </>
    )
}