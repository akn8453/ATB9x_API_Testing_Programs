package com.akshaynomulwar.ex02_RestAssured_Basic.DELETE;


import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class APITesting_013_DELETE_NONBddStyle {


    @Description("Verify the delete Request for the Restful Booker APIs")
    @Test
    public void test_patch_non_bdd(){

        String token = "e6ffdd48c67cb60";
        String bookingid = "360";




        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.log().all();

        Response response = requestSpecification.when().delete();

        ValidatableResponse validatableResponse = response.then().log().all();

        // validatableResponse.statusCode(200);
        validatableResponse.statusCode(201);

    }


}
