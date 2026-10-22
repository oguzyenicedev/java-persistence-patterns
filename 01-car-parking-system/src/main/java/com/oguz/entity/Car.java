package com.oguz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(name = "car_number", nullable = false)
    private int carNumber;

    @Column(name = "car_model", nullable = false, length = 50)
    private String carModel;

    public Car() {}

    public Car(int carId, int carNumber, String carModel) {
        this.carId = carId;
        this.carNumber = carNumber;
        this.carModel = carModel;
    }

    public Car(int carNumber, String carModel) {
        this.carNumber = carNumber;
        this.carModel = carModel;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}