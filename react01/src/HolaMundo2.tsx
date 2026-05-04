import React from "react";


export interface Hola2Props {
    name: string,
    age: number
}

function Hola2(props: Hola2Props) {
    const [name, setName] = React.useState("world!")
    const click = () => {
        setName(name === "world!" ? "React!" : "world!")
    }

    return (
        <>
            <h1>HEllO with </h1>
            {/*props.age ? <h4>Edad: {props.age}</h4>:<span></span>*/}
            {props.age && <h4>Edad:{props.age}</h4>}
            <button onClick={click}>Tocame</button>

        </>
    )
}

export default Hola2;