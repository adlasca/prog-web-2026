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
import jakarta.ws.rs.core.Response;
import uce.edu.ec.db.Comment;
import uce.edu.ec.repositories.CommentRepository;

@Path("/comments")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CommentRest {

    @Inject
    CommentRepository commentRepo;
    
    public CommentRest() {
    }

    @GET
    public List<Comment> findAll(){
        return commentRepo.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        return commentRepo.findOptionalBy(id)
        .map(Response::ok)
        .orElse(Response.status(Response.Status.NOT_FOUND))
        .build();
    }

    @POST
    public void save(Comment comment){
        commentRepo.save(comment);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Comment comment){
        commentRepo.findOptionalBy(id).ifPresent(existingComment->
            {
                
                commentRepo.save(comment);
            }
        );
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Integer id){
        commentRepo.findOptionalBy(id).ifPresent(existingComment->{
            commentRepo.remove(existingComment);
        });
    }
}
