package com.akshaynomulwar.ex02_RestAssured_Basic.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_Post_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

@Description("Verify the POST Req Postive")
@Test
    public void test_POST_NONBDDStyle(){

    String payload = " {\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    RequestSpecification r = RestAssured.given();
    r.baseUri("https://restful-booker.herokuapp.com");
    r.basePath("/auth");
    r.contentType(ContentType.JSON).log().all().post();
    r.body(payload);


    Response response1 = r.when().log().all().post();
    ValidatableResponse vr = response1.then().log().all().statusCode(200);

    }


}
