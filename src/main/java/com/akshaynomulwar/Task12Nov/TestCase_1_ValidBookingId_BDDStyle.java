package com.akshaynomulwar.Task12Nov;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCase_1_ValidBookingId_BDDStyle {

    //URL: https://restful-booker.herokuapp.com/booking/1
    //BaseURI: https://restful-booker.herokuapp.com
    //BasePath:/booking/1
    @Description("Check The booking id is valid or not")
    @Test
    public void ValidBooking_id (){

        String booking_id = "1";
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+booking_id)
                .when().log().all().get()
                .then()
                .statusCode(200);


    }
}
