package com.akshaynomulwar.ex05_PayLoadManagment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class APITesting_027_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingID;


    @Test
    public void test_POST(){

        String payload_POST = "{\n" +
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



        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname","Jim");
        jsonBodyUsingMap.put("lastname","Brown");
        jsonBodyUsingMap.put("totalprice","123");
        jsonBodyUsingMap.put("depositpaid","true");

        Map<String,Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("chekin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");


        jsonBodyUsingMap.put("bookingdates","bookingDatesMap");
        jsonBodyUsingMap.put("additionalNeeds","Breakfast");
        System.out.println(jsonBodyUsingMap);


      //  {firstname=Jim, lastname=Brown, totalprice=123, depositpaid=true, bookingdates=bookingDatesMap, additionalNeeds=Breakfast}

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();

        //get validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Dutta"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
        validatableResponse.body("bookingid",Matchers.notNullValue());

        // TestNG Assertions  -

        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.


        bookingID = response.then().extract().path("bookingId");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions

        Assert.assertNotNull(bookingID);
        Assert.assertEquals(firstname,"Jim");
        Assert.assertEquals(lastname,"Brown");

        // AssertJ( 3rd- Lib to Assertions)

        assertThat(bookingID).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotNull().isNotBlank();


    }
}
