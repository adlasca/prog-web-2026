package com.programacion.web.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/chao")
public class ChaoRest {
    @GET
    public String chao(){
        return  "Chao Rest";
    }
}
