package com.amansachan.Vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(String licenseNumber, VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return new Car(licenseNumber);
            case BIKE:
                return new Bike(licenseNumber);
            case TRUCK:
                return new Truck(licenseNumber);
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type");
        }

    }
}
