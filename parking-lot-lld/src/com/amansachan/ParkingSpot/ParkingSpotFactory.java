package com.amansachan.ParkingSpot;



public class ParkingSpotFactory {

    public static ParkingSpot createParkingSpot(String spotId, ParkingSpotType parkingSpotType) {
        if (parkingSpotType == ParkingSpotType.LARGE_SPOT) {
            return new LargeParkingSpot(spotId);
        } else if(parkingSpotType == ParkingSpotType.COMPACT_SPOT) {
            return new CompactParkingSpot(spotId);
        } else if(parkingSpotType == ParkingSpotType.BIKE_SPOT) {
            return new BikeParkingSpot(spotId);
        } else {
            throw new IllegalArgumentException("Invalid Parking Spot Type");
        }
    }
}
