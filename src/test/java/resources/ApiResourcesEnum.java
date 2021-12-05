package resources;

public enum ApiResourcesEnum {

    ADD_PLACE_API("/maps/api/place/add/json");

    private String resource;

    ApiResourcesEnum(String resource) {
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
