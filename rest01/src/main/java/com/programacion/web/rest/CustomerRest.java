package com.programacion.web.rest;

import com.programacion.web.dto.Customer;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.Map;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerRest {

    private static final Map<Integer, Customer> customers=Map.of(
            1,Customer.builder().id(1).name("cliente1").direccion("dir1").build(),
            2,Customer.builder().id(2).name("cliente1").direccion("dir2").build(),
            3,Customer.builder().id(3).name("cliente1").direccion("dir3").build()
    );
/*
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String findById(@PathParam("id") Integer id) {
        var customer = CustomerRest.customers.get(id);
        if(customer == null){
            return  "No se encontró el cliente";
        }

        String json= """
                {
                    "id": %d,
                    "name": %s,
                    "direccion": %s
                }
                """.formatted(
                        customer.getId(),
                customer.getName(),
                customer.getDireccion()
        );

        return json;
    }
*/

    @GET
    @Path("/{id}")
    //@Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findById(@PathParam("id") Integer id) {
        var obj = CustomerRest.customers.get(id);

        if(obj ==null){
            //Se usa .header("nombre", "valor") para añadir una linea mas a la cabecera
            return Response.status(Response.Status.NOT_FOUND).header("cabeza","cabecita").build();
        }
        return Response.ok(obj).build();
    }

    @POST
    //@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void save(@HeaderParam("Content-Type")String ContentType, Customer obj){
        System.out.println("*****"+ ContentType);
        System.out.println("SALIDA"+ obj);
    }

}
