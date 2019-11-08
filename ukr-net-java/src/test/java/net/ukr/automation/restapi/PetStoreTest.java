package net.ukr.automation.restapi;

import io.restassured.http.ContentType;
import io.swagger.petstore.models.Pet;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PetStoreTest {

    private String BASE_URI = "http://petstore.swagger.io/v2",
            apiKeyValue = "1qa2ws3ed4rfvcxz";

    @Test
    public void addNewPetToStoreTest() {
        Long testPetId = Long.parseLong(RandomStringUtils.randomNumeric(10));
        String testPetName = "Pet_" + RandomStringUtils.randomAlphabetic(10);

        given().baseUri(BASE_URI)
                .log().everything()
                .contentType(ContentType.JSON)
                .body(new Pet()
                        .name(testPetName)
                        .id(testPetId)
                        .status(Pet.StatusEnum.PENDING)
                        .tags(new ArrayList<>()))
                .header("api_key", apiKeyValue)
                .post("/pet").then().assertThat().body(matchesJsonSchemaInClasspath("PetSchema.json"));
    }

    @Test
    public void deletePetById() {
        Long testPetId = Long.parseLong(RandomStringUtils.randomNumeric(10));
        String testPetName = "Pet_" + RandomStringUtils.randomAlphabetic(10);

        //Add new pet to the store
        given().baseUri(BASE_URI)
                .log().everything()
                .contentType(ContentType.JSON)
                .body(new Pet()
                        .name(testPetName)
                        .id(testPetId)
                        .status(Pet.StatusEnum.PENDING)
                        .tags(new ArrayList<>()))
                .header("api_key", apiKeyValue)
                .post("/pet");

        //Delete pet by id from store
        given().baseUri(BASE_URI)
                .log().everything()
                .contentType(ContentType.JSON)
                .header("api_key", apiKeyValue)
                .when()
                .delete("/pet/" + testPetId);

        //Check that pet is absent
        given().baseUri(BASE_URI)
                .log().everything()
                .contentType(ContentType.JSON)
                .get("/pet/" + testPetId)
                .then()
                .body("message", equalTo("Hahahah"));
    }


}
