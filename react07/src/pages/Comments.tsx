import {Button, Container, Table, TableBody, TableCell, TableHead, TableRow, Typography} from "@mui/material";
import { useEffect, useState } from "react";
import axios from "axios";
import type{Comment} from '../models/Comment'
import { Link, useParams } from "react-router-dom";

function Comments(){

    const url ="https://jsonplaceholder.typicode.com/comments"
    const{id}= useParams<{id:string}>();

    const [comment,setComment] = useState<Comment[]>([]);

    useEffect(()=>{
        axios.get<Comment[]>(`${url}?postId=${id}`)
        .then(res=>{
            setComment(res.data)
        })
        .catch(err=>alert(err))

    })

    return(
        <>
            <Container>
                <Typography variant="h4" gutterBottom>Comments</Typography>

                <Table sx={{mt:2, border:2,color:"gray"}}>
                    <TableHead >
                        <TableRow>
                            <TableCell sx={{fontWeight:"bold"}}>Post ID</TableCell>
                            <TableCell sx={{fontWeight:"bold"}}>Comment ID</TableCell>
                            <TableCell sx={{fontWeight:"bold"}}>Nombre</TableCell>
                            <TableCell sx={{fontWeight:"bold"}}>Email</TableCell>
                            <TableCell sx={{fontWeight:"bold"}}>Descripción</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {comment.map((comment)=>(
                            <TableRow key ={comment.id}>
                                <TableCell>{comment.postId}</TableCell>
                                <TableCell>{comment.id}</TableCell>
                                <TableCell>{comment.name}</TableCell>
                                <TableCell>{comment.email}</TableCell>
                                <TableCell>{comment.body}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>

                </Table>

                <Button variant="outlined" component={Link} to={`/posts/${id}`} sx={{background:"inherit", marginTop:3}}>
                    Volver
                </Button>

            </Container>
        </>
    )

}
export default Comments;