import { Link, Route, Routes } from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import Contact from './pages/Contact'

function App() {

  return (
    <>
      <nav>

        <Link to='/home'>Home</Link>
        |
        <Link to='/contact'>Contact</Link>
      </nav>

      <Routes>
        <Route path="/home" element={<Home/>} />
        <Route path="/contact" element={<Contact/>} />
      </Routes>
    </>
  )
}

export default App
