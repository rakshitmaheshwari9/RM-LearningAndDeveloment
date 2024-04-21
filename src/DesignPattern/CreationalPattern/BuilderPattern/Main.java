package DesignPattern.CreationalPattern.BuilderPattern;

import DesignPattern.CreationalPattern.BuilderPattern.Car;

public class Main {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        Car car = new Car.Builder()
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2022)
                .build();
    }
}
