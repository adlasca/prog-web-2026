package uce.edu.ec;

import java.net.URI;

import jakarta.ws.rs.SeBootstrap;

public class RestPostMain {
    public static void main(String[] args) throws Exception {

    //var cdiContainer = SeContainerInitializer.newInstance().initialize();
    
        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()
                .host("localhost").port(8080).protocol("http").build();

        SeBootstrap.start(MyApplication.class, config)
                .thenAccept(instance ->{
                    System.out.println(instance);
                    URI uri = instance.configuration().baseUri();
                    System.out.println("Server started at: " + uri);
                    //EntityManagerFactory emf = CDI.current().select(EntityManagerFactory.class).get();
                    //var emf = CDI.current().select(EntityManagerFactory.class).get();
                    //System.out.println("EntityManagerFactory ready: " + emf);
                }).exceptionally(ex->{
                    System.err.println( "Failed to start server"+ex.getMessage());
                    return null;
                });
        Thread.currentThread().join();
    }
}
