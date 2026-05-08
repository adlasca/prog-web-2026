import { useParams } from "react-router-dom";

function Contact(){
    const {name}= useParams<{ name: string }>();
    return (
        <>
            <h1>Contact {name}</h1>
        </>
    )
}

export default Contact;