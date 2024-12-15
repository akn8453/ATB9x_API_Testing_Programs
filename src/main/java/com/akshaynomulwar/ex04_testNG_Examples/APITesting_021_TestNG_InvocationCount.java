package com.akshaynomulwar.ex04_testNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_021_TestNG_InvocationCount {

    @Test(invocationCount = 3)
    public void test01(){
        Assert.assertTrue(true);
    }
}
