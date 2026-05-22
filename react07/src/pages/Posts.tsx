import {Button, Container, Table, TableBody, TableCell, TableHead, TableRow, Typography} from "@mui/material";
import {useEffect, useState} from "react";
import axios from "axios";
import type{Post} from '../models/Post.ts'
import {Link} from "react-router";

function Posts() {

    const [posts, setPosts] = useState<Post[]>([]);
    const [loading, setLoading] = useState(false);
/*
    const fetchPosts = async () => {
        setLoading(true);


    }
*/
    useEffect(() => {
        axios.get<Post[]>("https://jsonplaceholder.typicode.com/posts")
            .then(res => {
                setPosts(res.data);
            })
            .catch(err => alert(err))
            .finally(() => setLoading(false));
    })

    return (
        <>
            <Container>
                <Typography variant="h4" gutterBottom>Posts</Typography>

                <Table sx={{mt:2}}>
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>Title</TableCell>
                            <TableCell>Description</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {posts.map((post) => (
                            <TableRow key ={post.id}>
                                <TableCell>{post.id}</TableCell>
                                <TableCell>{post.title}</TableCell>
                                <TableCell>{post.body}</TableCell>
                                <TableCell>
                                    <Button color={"secondary"} variant="outlined" component={Link} to={`/posts/${post.id}`}>Ver Detalle</Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </Container>
        </>
    )

}

export default Posts