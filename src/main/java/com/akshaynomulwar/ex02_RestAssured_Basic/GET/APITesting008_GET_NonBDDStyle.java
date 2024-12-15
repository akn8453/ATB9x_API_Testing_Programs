package com.akshaynomulwar.ex02_RestAssured_Basic.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    public void test_GET_NonBDDStyle_POSITIVE(){

        String pin_code = "560003";
         r = RestAssured

                .given();
                r.baseUri("https://api.zippopotam.us");
                r.basePath("/IN/" + pin_code);
                response = r.when().log().all().get();
                vr = response.then()
                .log().all()
                .statusCode(200);


        //REST Assured Interfaces

    }

    public void test_GET_NonBDDStyle_NEGATIVE(){

        String pin_code = "-1";
        r = RestAssured

                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pin_code);
        response = r.when().log().all().get();
        vr = response.then()
                .log().all()
                .statusCode(200);

    }
}
