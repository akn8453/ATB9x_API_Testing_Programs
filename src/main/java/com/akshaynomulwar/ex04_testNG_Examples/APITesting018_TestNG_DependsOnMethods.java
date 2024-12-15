package com.akshaynomulwar.ex04_testNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;
public class APITesting018_TestNG_DependsOnMethods {

    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1() {
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method2() {
        System.out.println("method1");
        Assert.assertTrue(true);

    }
}