import {useState} from "react";

interface Post {
    id: number;
    title: string;
    body: string;
}

function ConsumoFetch() {

    //const url = "https://jsonplaceholder.typicode.com/posts/";
    const [postId, setPostId] = useState("");
    const [post, setPost] = useState<Post | null>(null);
    const [loading, setLoading] = useState(true);
    const handleClick = () => {
        fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`,
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => response.json())
            //.then(data => alert(data.title));
            .then(data => {
                setPost(data);
            })
            .catch(error => alert(error))
            .finally(() => setLoading(false))
    }

    return (
        <>
            <h2>Fetch</h2>
            ID:
            <input type="text" placeholder="id"
                   value={postId}
                   onChange={e => setPostId(e.target.value)}/>
            <button onClick={handleClick}>Consultar</button>
            {loading && <p>Loading...</p>}
            <br/>
            {
                post && (
                    <div>
                        <p>ID: {post.id}</p>
                        <p>Title: {post.title}</p>
                        <p>Body: {post.body}</p>
                    </div>
                )
            }

        </>
    )
}

export default ConsumoFetch;