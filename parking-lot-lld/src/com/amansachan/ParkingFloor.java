package com.amansachan;

import com.amansachan.ParkingSpot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> parkingSpots;
    private final int floorNumber;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>();
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
