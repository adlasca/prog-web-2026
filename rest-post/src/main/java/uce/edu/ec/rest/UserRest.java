package uce.edu.ec.rest;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;
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
import uce.edu.ec.db.User;
import uce.edu.ec.repositories.UserRepository;

@ApplicationScoped
@ActivateRequestContext
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRest {

    @Inject
    UserRepository userRepo;

    public UserRest() {
    }

    @GET
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        return  userRepo.findOptionalBy(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public void save(User user) {
        userRepo.save(user);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, User user) {
        userRepo.findOptionalBy(id).ifPresent(existingUser->{
            
            userRepo.save(user);
        });
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Integer id) {
        userRepo.findOptionalBy(id).ifPresent(existingUser->{
            userRepo.remove(existingUser);
        });
    }

}
