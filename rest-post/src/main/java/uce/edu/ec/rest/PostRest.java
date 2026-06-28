package uce.edu.ec.rest;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.db.Post;
import uce.edu.ec.repositories.PostRepository;

@ApplicationScoped
@Path("/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostRest {

    @Inject
    PostRepository postRepo;

    public PostRest(){

    }

    @GET
    public List<Post> findAll(){
        return postRepo.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        return postRepo.findOptionalBy(id)
        .map(Response::ok)
        .orElse(Response.status(Response.Status.NOT_FOUND))
        .build();
    }

    @POST
    public void save(Post post){
        postRepo.save(post);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Post post){
        postRepo.findOptionalBy(id).ifPresent(existingPost->{
            
            postRepo.save(post);
        });
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Integer id){
        postRepo.findOptionalBy(id).ifPresent(existingPost->{
            postRepo.remove(existingPost);
        });
    }

}
