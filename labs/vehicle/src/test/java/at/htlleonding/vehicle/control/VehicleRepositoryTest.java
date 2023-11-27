package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import io.agroal.api.AgroalDataSource;
import io.quarkus.narayana.jta.QuarkusTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleRepositoryTest {

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    AgroalDataSource ds;

    @Test
    void createVehicle() {

        QuarkusTransaction.begin();
        Table vehicleTable = new Table(ds, "V_VEHICLE");
        output(vehicleTable).toConsole();

        Vehicle vehicle = new Vehicle("Opel","Commodore");
        vehicle = vehicleRepository.save(vehicle);
        vehicle.setModel("Kadett");
        //vehicleRepository.flush();
        QuarkusTransaction.commit();

        vehicleTable = new Table(ds, "V_VEHICLE");
        output(vehicleTable).toConsole();


        assertThat(vehicleTable)
                .hasNumberOfRows(1)
                .row(0)
                .value("BRAND").isEqualTo("Opel")
                .value("MODEL").isEqualTo("Commodore");
    }
}