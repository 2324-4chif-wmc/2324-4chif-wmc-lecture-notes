package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class VehicleRepository {

    @Inject
    EntityManager em;

    public Vehicle save(Vehicle vehicle) {
        return em.merge(vehicle);
    }

    public Vehicle save(String brand, String model) {
        return em.merge(new Vehicle(brand, model));
    }

    public Vehicle findById(long id) {
        return em.find(Vehicle.class, id);
    }

    // Das ist böse - da keine Typisierung
    public List findAllQuery() {
        Query query = em.createQuery("select v from Vehicle v");
        return query.getResultList();
    }

    public List<Vehicle> findAllTypedQuery() {
        TypedQuery<Vehicle> query = em.createQuery(
                "select v from Vehicle v",
                Vehicle.class
        );
        return query.getResultList();
    }

    public List<Vehicle> findAllNamedQuery() {

        return null;
    }

    public void flush() {
        em.flush();
    }

}
