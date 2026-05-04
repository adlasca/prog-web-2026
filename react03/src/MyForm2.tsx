function MyForm2() {

    function buscar(formData:FormData) {
        const nombre = formData.get("nombre")
        const edad = formData.get("edad")

        alert(`Nombre: ${nombre}, Edad:${edad}`)
    }

    return (
        <>
            <form action={buscar}>
                <div>
                    Nombre: <input type="text" name="nombre"/>
                    <br/>
                    Edad: <input type="text" name="edad"/>
                </div>
                <input type="submit" value="Enviar"  name="enviar"/>
            </form>
        </>
    )
}

export default MyForm2;