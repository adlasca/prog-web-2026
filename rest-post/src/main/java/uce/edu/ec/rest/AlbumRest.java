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
import uce.edu.ec.db.Album;
import uce.edu.ec.repositories.AlbumRepository;

@ApplicationScoped
@Path("/albums")
@Produces("application/json")
@Consumes("application/json")
public class AlbumRest {

    public AlbumRest() {
    }
    
    @Inject
    AlbumRepository albumRepository;

    @GET
    public List<Album>findAll(){
        return albumRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findbyId(@PathParam("id") Integer id){
        return albumRepository.findOptionalBy(id)
        .map(Response::ok)
        .orElse(Response.status(Response.Status.NOT_FOUND))
        .build();
    }

    @POST
    public void save(Album album){
        albumRepository.save(album);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Album album){
        albumRepository.findOptionalBy(id).ifPresent(existingAlbum->{
            
            albumRepository.save(album);
        });
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id")Integer id){
        albumRepository.findOptionalBy(id).ifPresent(existingAlbum->{
            albumRepository.remove(existingAlbum);
        });
    }

}
