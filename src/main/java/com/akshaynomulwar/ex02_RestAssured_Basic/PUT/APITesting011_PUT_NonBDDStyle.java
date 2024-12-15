package com.akshaynomulwar.ex02_RestAssured_Basic.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_NonBDDStyle {

    RequestSpecification requestSpecification;


    //PUT

    //Token bookingid - A
    //public void get_token(){}
    //public voig get_booking_id(){}

    @Description("Verify the PUT Request for the Restful Booker APIs")
    @Test
    public void test_put_non_bdd(){

        String token = "6d6d854a5f3afcc";
        String bookingid = "430";

        String payload ="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();
        Response response = requestSpecification.when().put();
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(403);


    }

}



