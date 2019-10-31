package ukr.net.groovy

import com.google.gson.Gson
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.Test

import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.when

class ChromeDriverTest {

    Url url = new Url();
    DesiredCapabilities capBody = new DesiredCapabilities("chrome")
    Gson gs = new Gson();


    @Test
    void startAndStopBrowser() {

        RestAssured.baseURI = "http://localhost:9515";

        when().get("/status")
                .then().statusCode(200);

        def res = given().
                contentType(ContentType.JSON).
                body(capBody).
                // body(StringBodies.getCapabilitiesBody("chrome")).
                when().
                post("/session");

        res.print()
        def sessionId = res.getBody().jsonPath().get("sessionId")

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", sessionId)
                .body(gs.toJson(url))
                .when()
                .post("/session/{id}/url").then().statusCode(200);

        given().delete("/session/" + sessionId).then().statusCode(200);

    }


}
