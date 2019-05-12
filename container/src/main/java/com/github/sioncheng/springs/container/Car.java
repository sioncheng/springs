package com.github.sioncheng.springs.container;

public class Car {

    private String name;

    public Car () {
        this("defaultCar");
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
