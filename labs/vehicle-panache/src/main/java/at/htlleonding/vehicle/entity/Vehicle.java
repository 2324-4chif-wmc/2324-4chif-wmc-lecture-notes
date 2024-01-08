package at.htlleonding.vehicle.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(
                name = "Vehicle.findAll",
                query = "select v from Vehicle v"
        ),
        @NamedQuery(
                name = "Vehicle.findByBrandAndModelNamedParameters",
                query = "from Vehicle where brand = :brand and model = :model"
        )
})
@Entity
@Table(name = "V_VEHICLE")
@XmlRootElement
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    @Column(name = "PRICE_PER_DAY")
    private double pricePerDay;

    //region constructors
    public Vehicle() {
    }

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Vehicle(String brand, String model, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    //endregion

    //region getter and setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%s %s (%f)", brand, model, pricePerDay);
    }

}
