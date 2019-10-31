package net.ukr.automation.selenium.restapi;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ChromeDriverTest {

    private Url url = new Url("https://mail.ukr.net");
    private Gson gs = new Gson();

    private String port = "9515";

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

    @Test
    public void startAndStopBrowser() {

        RestAssured.baseURI = "http://localhost:" + port;

        //Check if driver is ready
        when().get("/status")
                .then().statusCode(200);

        //Create Driver Session
        Response res = given().
                contentType(ContentType.JSON).
                body(bodySessionRequest).
                when().
                post("/session");

        //Extract SessionID
        String sessionId = res.getBody().jsonPath().get("sessionId");

        //Open Url in browser
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", sessionId)
                .body(gs.toJson(url))
                .when()
                .post("/session/{id}/url").then().statusCode(200);

        //Close session and close browser
        given().delete("/session/" + sessionId).then().statusCode(200);

    }

}
