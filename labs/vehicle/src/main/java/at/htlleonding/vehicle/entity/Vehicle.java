package at.htlleonding.vehicle.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle {

    private String brand;
    private String model;

    //region constructors
    public Vehicle() {
    }

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
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
    //endregion


    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
