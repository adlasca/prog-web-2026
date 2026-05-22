import {Route, Routes} from 'react-router-dom'
import './App.css'
import NavBar from './components/NavBar'
import Home from "./pages/Home.tsx";
import About from "./pages/About.tsx";
import Posts from "./pages/Posts.tsx";
import { ThemeProvider } from '@mui/material';


function App() {

    return (
        <>

            <NavBar/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/about" element={<About/>}/>
                <Route path="/posts" element={<Posts/>}/>
            </Routes>
        </>
    )
}

export default App
