package com.akshaynomulwar.ex04_testNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting020_TestNG_Enabled {

    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}