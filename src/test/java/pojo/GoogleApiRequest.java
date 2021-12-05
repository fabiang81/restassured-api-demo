package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GoogleApiRequest {

    private Location location;
    private Integer accuracy;
    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;
    private List<String> types;
    private String website;
    private String language;

}
