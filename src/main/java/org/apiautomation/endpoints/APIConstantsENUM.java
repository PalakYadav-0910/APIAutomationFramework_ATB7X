package org.apiautomation.endpoints;

public enum APIConstantsENUM {

    BASE_URL("https://restful-booker.herokuapp.com"),
    CREATE_UPDATE_BOOKING_URL("/booking"),
    AUTH_URL("/auth"),
    PING_URL("/ping");

    private final String url;

    APIConstantsENUM(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
