package com.akshaynomulwar.ex02_RestAssured_Basic.GET;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDDStyle {

    @Test
    public void test_GET_Req_POSTIVE() {
        String pin_code = "560003";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .statusCode(200);


    }


    @Test
    public void test_GET_Req_NEGATIVE() {
        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .statusCode(404);


    }
}

