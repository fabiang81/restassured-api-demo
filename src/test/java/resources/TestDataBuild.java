package resources;

import pojo.GoogleApiRequest;
import pojo.Location;

import java.util.Arrays;

public class TestDataBuild {

    public static GoogleApiRequest addPlacePayLoad(String name, String language, String address){
        GoogleApiRequest request = new GoogleApiRequest();
        request.setAccuracy(50);
        request.setAddress(address);
        request.setLanguage(language);
        request.setPhoneNumber("412-478-2367");
        request.setWebsite("https://google.com");
        request.setName(name);
        request.setTypes(Arrays.asList("shoe park", "shop"));
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        request.setLocation(location);

        return request;
    }

}
