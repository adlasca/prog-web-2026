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
import uce.edu.ec.db.Todo;
import uce.edu.ec.repositories.TodoRepository;

@ApplicationScoped
@Path("/todos")
@Consumes("application/json")
@Produces("application/json")
public class TodoRest {

    @Inject
    TodoRepository todoRepo;

    public TodoRest(){
    }

    @GET
    public List<Todo> findAll(){
        return todoRepo.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Integer id){
        return todoRepo.findOptionalBy(id)
        .map(Response::ok).orElse(Response.status(Response.Status.NOT_FOUND))
        .build();
        
    }

    @POST
    public void save(Todo todo){
        todoRepo.save(todo);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id")Integer id, Todo todo){
        todoRepo.findOptionalBy(id).ifPresent(existingTodo->{
            
            todoRepo.save(todo);
        });
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id")Integer id){
        todoRepo.findOptionalBy(id).ifPresent(existingTodo->{
            todoRepo.remove(existingTodo);
        });
    }

}
