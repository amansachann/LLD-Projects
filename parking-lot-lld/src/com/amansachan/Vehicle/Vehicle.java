package com.amansachan.Vehicle;

public abstract class Vehicle {

    protected String licenseNumber;
    protected VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Info: " + this.toString());
    }
}
