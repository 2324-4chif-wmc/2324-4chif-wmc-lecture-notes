package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;

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
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    public List<Vehicle> findByBrandAndModelNamedQueryWithNamedParameters(
            String brand,
            String model
    ) {
        TypedQuery<Vehicle> query = em.createNamedQuery(
                        "Vehicle.findByBrandAndModelNamedParameters",
                        Vehicle.class
                )
                .setParameter("brand", brand)
                .setParameter("model", model);
        return query.getResultList();
    }

    public void flush() {
        em.flush();
    }

    public List<Vehicle> findAllVehiclesNative() {
        Query query = em.createNativeQuery(
                """
                  select ID, BRAND, MODEL, PRICE_PER_DAY
                    from V_VEHICLE
                  """, Vehicle.class);
        return query.getResultList();
    }


}
