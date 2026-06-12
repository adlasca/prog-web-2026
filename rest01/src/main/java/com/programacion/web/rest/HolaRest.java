package com.programacion.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;

import java.time.LocalDateTime;
/**
 * localhost:8080/api/hola/
 */
@Path("/hola")
public class HolaRest {

    @GET
    @Path("/mundo1")
    public String hola1(){
        return "Hola Rest: " + LocalDateTime.now() ;
    }

    @GET
    @Path("/mundo2/{nombre}/{apellido}")
    public String hola2(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido){
        return "Hola %s:%s-->%s ".formatted(nombre,apellido, LocalDateTime.now().toString()) ;
    }

    @GET
    @Path("/mundo3")
    public String hola3(@QueryParam("nombre")String nombre,
                        @QueryParam("apellido")
                        @DefaultValue("Sin apellido")String apellido){
        return "Hola %s:%s-->%s ".formatted(nombre,apellido, LocalDateTime.now().toString()) ;
    }

    //----Evitar el uso de Context-----
    @GET
    @Path("/mundo4")
    public String hola4(@Context HttpServletRequest request){
        var host = request.getHeader("Host") ;
        return "Hola4 "+ host;
    }

}
