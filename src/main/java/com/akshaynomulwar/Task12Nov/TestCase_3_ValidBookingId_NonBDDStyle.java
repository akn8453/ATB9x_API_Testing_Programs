package com.akshaynomulwar.Task12Nov;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCase_3_ValidBookingId_NonBDDStyle {

    //URL: https://restful-booker.herokuapp.com/booking/1
    //BaseURI: https://restful-booker.herokuapp.com
    //BasePath:/booking/1

    RequestSpecification Request;
    Response response;
    ValidatableResponse Validate;

    @Test
    public void ValidBookingId(){

        String booking_Id = "1";
Request = RestAssured
        .given();
Request.baseUri("https://restful-booker.herokuapp.com");
Request.basePath("/booking/1");

response = Request
        .when()
        .log()
        .all()
        .get();

Validate = response
        .then()
        .log()
        .all()
        .statusCode(200);








    }

}
