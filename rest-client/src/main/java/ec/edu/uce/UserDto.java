package ec.edu.uce;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

    private Integer id;
    
    private String name;
    private String username;
    private String email;
    private String addressStreet;
    private String addressSuite;
    private String addressCity;
    private String addressZipcode;
    private String addressGeoLat;
    private String addressGeoLng;
    private String phone;
    private String website;
    private String companyName;
    private String companyCatchPhrase;
    private String companyBs;

}
