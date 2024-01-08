package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;

import java.util.List;


@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {


    public void xy() {

    }

}
