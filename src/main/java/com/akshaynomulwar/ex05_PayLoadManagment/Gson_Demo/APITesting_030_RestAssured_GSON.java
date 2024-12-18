package com.akshaynomulwar.ex05_PayLoadManagment.Gson_Demo;


import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class APITesting_030_RestAssured_GSON {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void test_Create_Booking_Positive() {

        //Step1 - POST
        // URL -> Base URI + Base Path
        // Header
        // BODY
        // AUTH - NO

        //Step2
        //Prepare the payload (Object -> JSON String)
        //Send the request

        //Step3
        //Validate Response (JSON String -> Object)
        //FirstName
        //StatusCode
        //Time Response


        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckout("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

 // Java object -> JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString  = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        //Case1 - Extract
        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        //Case2 - JsonPath.getString
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        System.out.println(bookingId);
        System.out.println(firstname);

        //Case 3 - DeSer - Extraction
        BookingResponse bookingResponse = gson.fromJson(jsonResponseString,BookingResponse.class);
        System.out.println(bookingResponse.getBooking());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jim");



    }
}
