package ec.edu.uce;


import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

public class RestClientMain {
    public static final String USERS_URL = "http://localhost:8080/users/";
    static void main()  {

        try(var client = ClientBuilder.newClient()){
            UserDto user1 = client.target(USERS_URL)
                    .path("/{id}")
                    .resolveTemplate("id",1)
                    .request(MediaType.APPLICATION_JSON)
                    .get(UserDto.class);
            
            //-----GET------
            //var users =client.target(USERS_URL).request(MediaType.APPLICATION_JSON).get(String.class);


            //En listas
            UserDto[] usersTmp = client.target(USERS_URL)
                            .request(MediaType.APPLICATION_JSON)
                                    .get(UserDto[].class);

            List<UserDto> users = client.target(USERS_URL)
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<>(){});

            //var users = Arrays.asList(usersTmp);

            System.out.println(users);

            //-----POST-----

            var newUser = new UserDto();

            newUser.setAddressCity("City");
            newUser.setAddressGeoLng("GeoLog");
            newUser.setAddressGeoLat("LAt");
            newUser.setAddressStreet("Street");
            newUser.setAddressSuite("Suite");
            newUser.setAddressZipcode("ZIP");
            newUser.setCompanyBs("BS");
            //nonull
            var idx = System.currentTimeMillis();

            newUser.setUsername("UserName"+idx);
            newUser.setName("KOKUN"+idx);
            newUser.setEmail("email.%d@koku.com".formatted(+idx));

            var response = client.target(USERS_URL)
                    .request(MediaType.APPLICATION_JSON)
       //             .post(Entity.entity(newUser,MediaType.APPLICATION_JSON));
               .post(Entity.json(newUser));

            System.out.println("STATUS: "+response.getStatus());


            //-----PUT y DELETE COMPLETAR-----


        }
    }
}
