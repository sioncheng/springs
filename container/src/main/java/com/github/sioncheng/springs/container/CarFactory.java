package com.github.sioncheng.springs.container;

public class CarFactory {

    public Car build() {
        return new Car("factoryCar");
    }
}
