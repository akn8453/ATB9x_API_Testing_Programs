package com.akshaynomulwar.ex03_testNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_022_TestNG_InvocationCount {

    @Test(invocationCount = 3)
    public void test01(){
        Assert.assertTrue(true);
    }
}
