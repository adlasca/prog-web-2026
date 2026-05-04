
import {useState} from "react";

function MyForm() {

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>): void => {
        alert(`Texto ingresado ${name}`)
        event?.preventDefault()
    }

    const [name,setName]=useState('')

    const handleChange=(event:React.ChangeEvent<HTMLInputElement>) => {
        setName(event.target.value)
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <div>
                    Nombre: <input type="text" value={name} onChange={handleChange} />
                </div>

                <input type="submit" value="Enviar1"/>
                <input type="submit" value="Enviar2"/>
                <input type="submit" value="Button"/>
                <div>{name}</div>
            </form>
        </>
    )
}

export default MyForm;