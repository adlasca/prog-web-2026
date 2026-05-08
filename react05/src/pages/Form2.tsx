import {useLocation, useNavigate} from "react-router-dom";

function Form2() {

    const navigate = useNavigate();
    const location = useLocation();

    const state = location.state as { message: string } ||null;

    const handleRegresar = () => {
        navigate('/')
    }
    return (
        <form>
            <h2>Formulario 2</h2>
            {state && state.message ? (
                <> Nombre recibido: {state.message}</>
            ) : (
                <p>No se recibio ningun mensaje</p>
            )}
            <p>

            </p>
            <button type='button' onClick={handleRegresar}>Regresar</button>
        </form>
    )
}

export default Form2;