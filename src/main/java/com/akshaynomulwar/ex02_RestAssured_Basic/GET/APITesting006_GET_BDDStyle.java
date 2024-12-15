package com.akshaynomulwar.ex02_RestAssured_Basic.GET;

import io.restassured.RestAssured;

public class APITesting006_GET_BDDStyle {
    public static void main(String[] args) {

        String pincode = "560003";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

        pincode = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }
}
