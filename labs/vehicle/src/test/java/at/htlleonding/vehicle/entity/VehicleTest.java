package at.htlleonding.vehicle.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void createVehicle() {
        // arrange

        // act
        Vehicle opel = new Vehicle("Opel", "Commodore");


        // assert
        assertThat(opel.getBrand()).isEqualTo("Opel");
        assertThat(opel.getModel()).isEqualTo("Commodore");

    }
}