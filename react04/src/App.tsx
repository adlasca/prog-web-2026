import {Link, Route, Routes} from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import Contact from './pages/Contact'

function App() {

    return (
        <>
            <nav>

                <Link to='/home'>Home</Link>
                |
                <Link to='/contact/test1'>Contact1</Link>
                |
                <Link to='/contact/test2'>Contact2</Link>
            </nav>

            <Routes>
                <Route path="/home" element={<Home/>}/>
                //ruta variable con /:name
                <Route path="/contact/:name" element={<Contact/>}/>
            </Routes>
        </>
    )
}

export default App
