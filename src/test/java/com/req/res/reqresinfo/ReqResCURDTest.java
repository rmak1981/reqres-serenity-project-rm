package com.req.res.reqresinfo;

import com.req.res.model.ReqResPojo;
import com.req.res.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.req.res.utils.TestUtils.getRandomValue;
import static org.hamcrest.CoreMatchers.hasItems;

/*
 * Ravi's Creation
 * Date of Creation 17/05/2020
 */

@RunWith(SerenityRunner.class)

public class ReqResCURDTest extends TestBase {


    static String name = "SUPERMAN" + getRandomValue();
    static String job = "Software Testing";
    static String email = "SUPERMAN" + getRandomValue() + "@avengers.com";
    static String password = "abc123";


    @Title("Create Request")
    @Test
    public void createRequest() {

        ReqResPojo reqResPojo = new ReqResPojo();

        reqResPojo.setName(name);
        reqResPojo.setJob(job);
        reqResPojo.setEmail(email);
        reqResPojo.setPassword(password);

        SerenityRest.rest()

                .given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .when()
                .body(reqResPojo)
                .post("/users")
                .then()
                .log().all()
                .statusCode(201);

    }
    @Title("This test will User from the updated record")
    @Test
    public void test002() {

        ReqResPojo reqResPojo = new ReqResPojo();
        reqResPojo.setName(name = "Byron");

        SerenityRest.rest()
                .header("Content-Type", "application/json")
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.first_name", hasItems(name));

    }

    @Title("This test will update details of an user id 10 ")
    @Test
    public void test003() {
        ReqResPojo reqResPojo = new ReqResPojo();
        reqResPojo.setName(name = "Janak");
        reqResPojo.setJob(job = "archary");

        SerenityRest.rest()
                .given()
                .header("Content-Type", "application/json")
                .when()
                .body(reqResPojo)
                .put("/5")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Title("This test will delete the  User")
    @Test
    public void test004() {
        SerenityRest.rest().given()
                .when()
                .delete("/users/5")
                .then().statusCode(204)
                .log().status();

    }

}