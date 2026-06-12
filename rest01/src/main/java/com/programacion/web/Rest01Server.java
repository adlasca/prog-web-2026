package com.programacion.web;

import com.programacion.web.rest.HolaRest;
import jakarta.ws.rs.SeBootstrap;
import jakarta.ws.rs.core.Application;

import java.net.URI;

public class Rest01Server  {
    static void main() throws Exception {

        Application app = new MyApplication();
        HolaRest hola = new HolaRest();

        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()
                .host("localhost").port(8080).protocol("http").build();

        SeBootstrap.start(MyApplication.class, config)
                .thenAccept(instance ->{
                    System.out.println(instance);
                    URI uri = instance.configuration().baseUri();
                    System.out.println("Server started at: " + uri);
                }).exceptionally(ex->{
                    System.err.println( "Failed to start server"+ex.getMessage());
                    return null;
                });
        Thread.currentThread().join();
    }
}
