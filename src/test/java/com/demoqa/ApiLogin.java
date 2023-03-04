package com.demoqa;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiLogin {

    @Test
    public void postValid() {
        RestAssured.baseURI = "https://demoqa.com/books/login";
        given().urlEncodingEnabled(true)
                .param("username", "LubaSapr")
                .param("password", "26012023Sa@")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/login")
                .then().statusCode(200);
    }

    @Test
    public void postNeValid() {
        RestAssured.baseURI = "https://demoqa.com/books/login";
        given().urlEncodingEnabled(true)
                .param("username", "LubaSapr")
                .param("password", "26012023Sa@")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/login")
                .then().statusCode(404);
    }
    @Test
    public void postInValid() {
        RestAssured.baseURI = "https://demoqa.com/books/login";
        given().urlEncodingEnabled(true)
                .param("username", "String")
                .param("password", "26012023Sa@")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/login")
                .then().statusCode(404);
    }
    @Test
    public void getNotMyPostNotAuthTest(){
        RestAssured.
                when().get("https://demoqa.com/books").
                then().assertThat().statusCode(200);
    }
    @Test
    public void getNotMyPostTest() {
        given()
                .headers("X-Auth-Token", "string")
                .when()
                .get("https://demoqa.com/books")
                .then()
                .statusCode(200);
    }
    @Test
    public void getNotMyPostPositiveTest() {
        given()
                .headers("X-Auth-Token", "string")

                .expect()
                .body("title", equalTo("Git Pocket Guide"))
                .body("title", equalTo("Learning JavaScript Design Patterns"))
                .body("title", equalTo("Designing Evolvable Web APIs with ASP.NET"))
                .body("title", equalTo("Speaking JavaScript"))
                .body("title", equalTo("Programming JavaScript Applications"))
                .body("title", equalTo("Programming JavaScript Applications"))
                .body("title", equalTo("Eloquent JavaScript, Second Edition"))
                .body("title", equalTo("Understanding ECMAScript 6"))
                .when()
                .get("https://demoqa.com/books");

    }

    @Test
    public void getMyPostNotAuthTest(){
        RestAssured.
                when().get("https://demoqa.com/books").
                then().assertThat().statusCode(200);
    }
    @Test
    public void getMyPostTest() {
        given()
                .headers("X-Auth-Token", "string")
                .when()
                .get("https://demoqa.com/books")
                .then()
                .statusCode(200);
    }

}

