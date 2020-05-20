package com.req.res.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/*
 * Ravi's Creation
 * Date of Creation
 */

public class TestBase {
@BeforeClass
    public static void inIt(){


        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
}
}
