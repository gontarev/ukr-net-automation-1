package ukr.net.groovy

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.Test

import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.when

class ChromeDriverTest {


    @Test
    void startAndStopBrowser() {

        RestAssured.baseURI = "http://localhost:9515";

        when().get("/status")
                .then().statusCode(200);

        def res = given().
                contentType(ContentType.JSON).
                body(new DesiredCapabilities("chrome")).
                // body(StringBodies.getCapabilitiesBody("chrome")).
                when().
                post("/session");


        def sessionId = res.getBody().jsonPath().get("sessionId")

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", sessionId)
                .body(new Url("https://mail.ukr.net"))
                .when()
                .post("/session/{id}/url").then().statusCode(200);

        given().delete("/session/" + sessionId).then().statusCode(200);

    }


}
