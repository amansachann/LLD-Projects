package com.amansachan.ParkingSpot;

import com.amansachan.Vehicle.Vehicle;

public abstract class ParkingSpot {
    protected String spotId;
    protected Vehicle vehicle;
    protected boolean isOccupied;
    protected ParkingSpotType spotType;

    public ParkingSpot(String spotId, ParkingSpotType spotType) {
        this.spotId = spotId;
        this.vehicle = null;
        this.isOccupied = false;
        this.spotType = spotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId='" + spotId + '\'' +
                ", vehicle=" + vehicle +
                ", isOccupied=" + isOccupied +
                ", spotType=" + spotType +
                '}';
    }

    public void displayParkingSpotInfo() {
        System.out.println("Parking Spot Info: " + this.toString());
    }
}
