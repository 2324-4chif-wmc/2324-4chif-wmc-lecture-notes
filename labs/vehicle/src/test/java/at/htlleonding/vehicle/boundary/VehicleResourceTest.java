package at.htlleonding.vehicle.boundary;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class VehicleResourceTest {

    @Test
    void testVehicleEndpoint() {

        given()
        .when()
                .get("/vehicle")
        .then()
                .log().body()
                .statusCode(200)
                .body("brand[0]",is("Opel"),
                        "model[0]", is("Senator"),
                        "brand[1]",is("Opel"),
                        "model[1]", is("Kapitän")
                );



    }
}