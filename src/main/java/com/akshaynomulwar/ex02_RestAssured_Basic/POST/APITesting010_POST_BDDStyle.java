package com.akshaynomulwar.ex02_RestAssured_Basic.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting010_POST_BDDStyle {

    @Description("Verify the post req Positve")
    @Test
    public void test_POST_NonBDDStyle(){

        //   TC > 100 -> Non BDD
        // TC < 100 ->   BDD
       //url body header

        /*
        {
    "username" : "admin",
    "password" : "password123"
}
         */

        //AUTH?

        String payload = " {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth/")
                .contentType(ContentType.JSON)
                .log().all().body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);


    }
}
