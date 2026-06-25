package uce.edu.ec;

import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.SeBootstrap;
import jakarta.ws.rs.core.Application;
import uce.edu.ec.repositories.UserRepository;

import java.net.URI;

public class RestPostMain {
    public static void main(String[] args) throws Exception {

        var cdiContainer =SeContainerInitializer.newInstance().initialize();

        var repo = cdiContainer.select(UserRepository.class).get();

        //var emf = Persistence.createEntityManagerFactory("progweb");

        //var em =emf.createEntityManager();


        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()
                .host("0.0.0.0").port(8080).protocol("http").build();

        SeBootstrap.start(MyApplication.class, config)
                .thenAccept(instance ->{
                    System.out.println(instance);
                    URI uri = instance.configuration().baseUri();
                    System.out.println("Server started at: " + uri);
                    var emf = CDI.current().select(EntityManagerFactory.class);
                }).exceptionally(ex->{
                    System.err.println( "Failed to start server"+ex.getMessage());
                    return null;
                });
        Thread.currentThread().join();
    }
}
