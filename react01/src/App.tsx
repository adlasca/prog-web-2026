import React from "react";
import Hola from "./Hola.tsx";
import { Contador } from "./Contador.tsx";
import HolaMundo2, {type Hola2Props} from "./HolaMundo2.tsx";

function App() {

    const [txt, setTxt] = React.useState("Jose")

    const handleClick = () => {
        //alert("Me tocaste 0-=|= °w°");

        if (txt === "Jose") {
            setTxt("React");
        } else {
            setTxt("Jose")
        }
    }

    const props: Hola2Props = {
        name: "world!",
        age: 21
    };

    return (
        <>
            Hola <span>{txt}</span>
            <br/>
            <button onClick={handleClick}>Touch me</button>
            <hr/>
            <Hola name={"Jose"} age={17}/>
            <hr/>
            <HolaMundo2 {...props}/>
            <hr/>
            <Contador />
        </>

    )
}

export default App
