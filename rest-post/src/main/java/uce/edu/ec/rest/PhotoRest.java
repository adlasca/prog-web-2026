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
import uce.edu.ec.db.Photo;
import uce.edu.ec.repositories.PhotoRepository;

@ApplicationScoped
@Path("/photos")
@Consumes("application/json")
@Produces("application/json")
public class PhotoRest {

    public PhotoRest(){
    }

    @Inject
    PhotoRepository photoRepo;

    @GET
    public List<Photo> findAll(){
        return photoRepo.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        return photoRepo.findOptionalBy(id)
        .map(Response::ok)
        .orElse(Response.status(Response.Status.NOT_FOUND
        )).build();
    }

    @POST
    public void save(Photo photo){
        photoRepo.save(photo);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id,Photo photo){
        photoRepo.findOptionalBy(id).ifPresent(existingPhoto->{
            
            photoRepo.save(photo);
        });
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        photoRepo.findOptionalBy(id).ifPresent(existingPhoto->{
            photoRepo.remove(existingPhoto);
        });
    }


}
