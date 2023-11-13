package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class VehicleRepository {

    @Inject
    EntityManager em;

    public void save(Vehicle vehicle) {
        //em.
    }

}
