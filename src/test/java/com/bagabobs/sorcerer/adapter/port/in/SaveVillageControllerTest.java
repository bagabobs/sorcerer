package com.bagabobs.sorcerer.adapter.port.in;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SaveVillageControllerTest {
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    void calculateAverageIsOk() {
        String bodyString = """
                [
                    {
                        "ageAtDeath": "10",
                        "yearOfDeath": "12"
                    },
                   {
                        "ageAtDeath": "13",
                        "yearOfDeath": "17"
                    }
                ]
                """;

        given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .post("/api/village/calculateaverage")
                .then()
                .statusCode(200)
                .assertThat()
                .body("avgYearOfDeath", equalTo(4.5F));

    }

    @Test
    void calculateAverageAgeAtDeathIsMoreThenYearOfDeathWillReturnMinusOne() {
        String bodyString = """
                [
                    {
                        "ageAtDeath": "10",
                        "yearOfDeath": "12"
                    },
                   {
                        "ageAtDeath": "18",
                        "yearOfDeath": "17"
                    }
                ]
                """;

        given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .post("/api/village/calculateaverage")
                .then()
                .statusCode(200)
                .assertThat()
                .body("avgYearOfDeath", equalTo(-1.0F));

    }
}
