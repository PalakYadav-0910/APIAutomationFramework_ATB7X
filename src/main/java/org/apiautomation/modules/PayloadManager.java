package org.apiautomation.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.apiautomation.pojos.*;

public class PayloadManager {

    //Serialization and DeSerialization

    //Converting the JAVA Object to String
    //{}
    public String createPayloadBookingAsString(){
         Booking booking = new Booking();
         booking.setFirstname("James");
         booking.setLastname("Brown");
         booking.setTotalprice(111);
         booking.setDepositpaid(true);

         BookingDates bookingDates = new BookingDates();
         bookingDates.setCheckin("2024-02-01");
         bookingDates.setCheckout("2024-02-01");

         booking.setBookingdates(bookingDates);
         booking.setAdditionalneeds("Breakfast");
         System.out.println(booking);

         //Java Object -> JSON String (byteStream) -> Serialization
         Gson gson = new Gson();
         String jsonStringPayload = gson.toJson(booking);
         System.out.println(jsonStringPayload);
         return jsonStringPayload;
    }

    public String createPayloadBookingAsStringFaker(){

        Faker faker = new Faker();

        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1000));
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking);

        //Java Object -> JSON String (byteStream) -> Serialization
        Gson gson = new Gson();
        String jsonStringPayload = gson.toJson(booking);
        System.out.println(jsonStringPayload);
        return jsonStringPayload;
    }

    public BookingResponse bookingResponseJava(String responseString){

        Gson gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    //get Token
    public String setAuthPayload(){

        //Auth Object -> json String

        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        Gson gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;

    }

    public String getTokenFromJSON(String tokenResponse){

        Gson gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();

    }

    //get Booking Id
    public Booking getResponseFromJSON(String getResponse){

        Gson gson = new Gson();
        //Response(JSON) -> Object TokenResponse
        //DeSerialization

        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;

    }

    public String fullUpdatePayloadAsString(){

        Booking booking = new Booking();
        booking.setFirstname("Palak");
        booking.setLastname("Yadav");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-05");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        Gson gson = new Gson();
        String payload = gson.toJson(booking);

        return payload;

    }


}
