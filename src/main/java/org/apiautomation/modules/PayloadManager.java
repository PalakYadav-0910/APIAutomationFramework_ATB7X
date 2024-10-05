package org.apiautomation.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.apiautomation.pojos.Booking;
import org.apiautomation.pojos.BookingDates;
import org.apiautomation.pojos.BookingResponse;

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

}
