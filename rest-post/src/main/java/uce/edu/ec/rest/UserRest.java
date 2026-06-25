package uce.edu.ec.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import uce.edu.ec.db.User;
import uce.edu.ec.repositories.UserRepository;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRest {
    final UserRepository userRepo;

    @Inject
    public UserRest(UserRepository userRepo) {
        this.userRepo = userRepo;
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
