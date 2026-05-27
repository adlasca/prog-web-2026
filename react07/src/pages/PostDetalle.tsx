import {Box, Button, Card, CardActions, CardContent, TextField, Typography} from "@mui/material";
import axios from "axios";
import { useParams } from "react-router-dom";
import type{Post} from "../models/Post.ts"
import {useState} from "react";
import {Link} from "react-router";
function PostDetalle() {

    const url ="https://jsonplaceholder.typicode.com/posts"
    const {id} = useParams<{ id: string }>();
    const [post, setPost] = useState<Post>({id:0,title:"",body:""});

    const handleGuardar=async()=>{
        axios.post<Post>(`${url}`,post)
            .then(response => setPost(response.data))
            .catch(error=>alert(error));
    }

    axios.get<Post>(`${url}/${id}`)
        .then(response=>{
            setPost(response.data);
        })
        .catch(error =>alert(error));

    return (<>

        <Box sx={{maxWidth:600, margin:"20px auto",  px: 2}}>
            <Card variant={"outlined"} sx={{borderRadius:3}}>
                <CardContent sx={{display: "flex", flexDirection: "column", gap:3, p:4} }>

                    <Box sx={{display: "flex", justifyContent: "space-between", alignItems: "center"}}>
                        <Typography variant="h6" component="h2" sx={{fontWeight:"bold"}}>
                            Editar Post
                        </Typography>
                        <Typography variant="caption" color =  "text.secondary" sx={{fontWeight:"bold"}}>
                            <b>Id: {post.id}</b>
                        </Typography>
                    </Box>

                    <TextField
                        label={"Titulo del post"}
                        variant="outlined"
                        value={post.title}
                        fullWidth
                        onChange={e=>setPost({...post,title:e.target.value})}

                    />

                    <TextField
                        label={"Contenido"}
                        variant="outlined"
                        value={post.body}
                        fullWidth
                        onChange={e=>setPost({...post,body:e.target.value})}
                    />

                </CardContent>

                <CardActions sx={{justifyContent:"flex-start",px:4,pb:4}}>
                    <Button variant="outlined" color="inherit" onClick={handleGuardar}>
                        Guardar
                    </Button>

                    <Button variant="outlined" color="inherit" component={Link} to={"/posts"}>
                        Volver
                    </Button>

                    <Button variant="outlined" color="inherit" component ={Link} to ={`/comments/${post.id}`}>
                        Comentarios
                    </Button>
                </CardActions>

            </Card>
        </Box>
        <div>{post.title}</div>
        <div>{post.body}</div>
    </>)
}
//EJERCICIO: añadir boton ver comentarios y diriga a otra pagina que se vean los comentarios
export default PostDetalle;