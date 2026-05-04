import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import Home from './pages/Home'
import Contact from './pages/Contact'
import App from './App.tsx'
import {BrowserRouter} from 'react-router-dom'

createRoot(document.getElementById('root')!).render(
    <StrictMode>
        <BrowserRouter>
            <App/>
        </BrowserRouter>
    </StrictMode>,
)
