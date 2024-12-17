package com.akshaynomulwar.ex03_testNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameters {

    @Parameters("browser")
    @Test
    public void demo1(String value) {
        System.out.println("Browser is " + value);
        // Open the Browser and select dadadada
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my Testing Chrome");
        }
        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my Firefox");
        }

    }





}
