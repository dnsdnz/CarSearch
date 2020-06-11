package com.denizcakmak.carsearch.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component    //Car class is a spring Bean, bean: Spring container,manager
@Scope("prototype")  //Bean scope, protoype means different instance for every equest
public class Car {
    private String brand;
    private String model;
    private String carClass;

    @Override  //implement methods from parent
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", carClass='" + carClass + '\'' +
                '}';
    }
    public Car() {
    }

    //setter and getter functions

    public Car(String brand, String model, String carClass) {
        this.brand = brand;
        this.model = model;
        this.carClass = carClass;
    }

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

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }
}
