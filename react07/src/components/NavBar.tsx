import {AppBar, Button, Toolbar, Typography} from "@mui/material";
import HomeIcon from "@mui/icons-material/Home";
import {Link} from "react-router";
import { Description, Info } from "@mui/icons-material";

function NavBar() {
    return (
        <>
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6" sx={{flexGrow: 1}}>
                        Mi Aplicación
                    </Typography>

                    <Button color="inherit" component={Link} to="/" startIcon={<HomeIcon/>}>Inicio</Button>
                    <Button color="inherit" component={Link} to={'/about'} startIcon={<Info/>}>Acerca de</Button>
                    <Button color="inherit" component={Link} to={'/posts'} startIcon={<Description/>}>Posts</Button>
                </Toolbar>
            </AppBar>
        </>
    )
}

export default NavBar;