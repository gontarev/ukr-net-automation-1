package net.ukr.automation.selenium.restapi;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ChromeDriverTest {

    @Test
    public void startAndStopBrowser() {

        String bodySessionRequest = "{\n" +
                "  \"desiredCapabilities\": {\n" +
                "    \"browserName\": \"chrome\",\n" +
                "    \"goog:chromeOptions\": {\n" +
                "      \"args\": [\n" +
                "      ],\n" +
                "      \"extensions\": [\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";

        RestAssured.baseURI = "http://localhost:9515";

        //Check if driver is ready
        when().get("/status")
                .then().statusCode(200);

        //Create Driver Session and extract sessionID
        String sessionId = given()
                .contentType(ContentType.JSON)
                .body(bodySessionRequest)
                .when()
                .post("/session")
                .getBody()
                .jsonPath()
                .getString("sessionId");

        //Open Url in browser
        given().contentType(ContentType.JSON)
                .pathParam("id", sessionId)
                .body(new Gson().toJson(new Url("https://mail.ukr.net")))
                .when()
                .post("/session/{id}/url").then().statusCode(200);

        //Close session and close browser
        given().delete("/session/" + sessionId).then().statusCode(200);
    }

}
