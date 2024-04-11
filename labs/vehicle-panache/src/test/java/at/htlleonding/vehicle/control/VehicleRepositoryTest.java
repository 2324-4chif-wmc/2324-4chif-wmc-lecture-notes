package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import io.agroal.api.AgroalDataSource;
import io.quarkus.narayana.jta.QuarkusTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleRepositoryTest {

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    AgroalDataSource ds;


//    @Test
//    void createVehicle() {
//
//        QuarkusTransaction.begin();
//        Table vehicleTable = new Table(ds, "V_VEHICLE");
//        output(vehicleTable).toConsole();
//
//        Vehicle vehicle = new Vehicle("Opel", "Commodore");
//        vehicle = vehicleRepository.save(vehicle);
//        vehicle.setModel("Kadett");
//        //vehicleRepository.flush();
//        QuarkusTransaction.commit();
//
//        vehicleTable = new Table(ds, "V_VEHICLE");
//        output(vehicleTable).toConsole();
//
//
//        assertThat(vehicleTable)
//                .hasNumberOfColumnsGreaterThan(1)
//                .row(0)
//                .value("BRAND").isEqualTo("Opel")
//                .value("MODEL").isEqualTo("Commodore");
//    }
//
//    @Test
//    void listAllVehiclesWithNamedQuery_Ok() {
//        var vehicles = vehicleRepository.findAllNamedQuery();
//        System.out.println(vehicles);
//    }

//    @Test
//    void listVehiclesByBrandAndModellWithNamedParametersQuery_ok() {
//        var vehicles = vehicleRepository.findByBrandAndModelNamedQueryWithNamedParameters(
//                "Opel",
//                "Blitz"
//        );
//        System.out.println(vehicles);
////        Table vehicle = new Table(ds, "V_VEHICLE");
////        assertThat(vehicle)
//        org.assertj.core.api.Assertions.assertThat(vehicles)
//                .hasSize(1);
//
//    }

//    @Test
//    void testFindAllVehiclesNative() {
//        var actualVehicles = vehicleRepository.findAllVehiclesNative();
//        System.out.println(actualVehicles);
//        org.assertj.core.api.Assertions.assertThat(actualVehicles)
//                .hasSize(2)
//                .contains(List.of(
//                                new Vehicle("Opel", "Blitz", 50.0),
//                                new Vehicle("VW", "Käfer 1400", 30.0)
//                        )
//                );
//    }
}