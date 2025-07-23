package com.amansachan;

import com.amansachan.Fee.FlatRateStrategy;
import com.amansachan.Fee.VehicleBasedFeeStrategy;
import com.amansachan.ParkingSpot.ParkingSpotFactory;
import com.amansachan.ParkingSpot.ParkingSpotType;
import com.amansachan.Vehicle.Vehicle;
import com.amansachan.Vehicle.VehicleFactory;
import com.amansachan.Vehicle.VehicleType;

public class Client {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingFloor floor1 = new ParkingFloor(1);

        // populate parking floor with empty spots
        for(int i = 0; i < 30; i++) {
            floor1.getParkingSpots().add(ParkingSpotFactory.createParkingSpot("S" + i + 1, ParkingSpotType.BIKE_SPOT));
        }
        for(int i = 0; i < 20; i++) {
            floor1.getParkingSpots().add(ParkingSpotFactory.createParkingSpot("M" + i + 1, ParkingSpotType.COMPACT_SPOT));
        }
        for(int i = 0; i < 10; i++) {
            floor1.getParkingSpots().add(ParkingSpotFactory.createParkingSpot("L" + i + 1, ParkingSpotType.LARGE_SPOT));
        }

        // add floor to the parking lot
        parkingLot.getParkingFloors().add(floor1);

        // set fee strategy
        parkingLot.feeStrategy = new FlatRateStrategy();

        // Vehicles
        Vehicle car1 = VehicleFactory.createVehicle("UP78 GE 9424", VehicleType.CAR);
        Vehicle car2 = VehicleFactory.createVehicle("UP78 FT 8764", VehicleType.CAR);
        Vehicle bike = VehicleFactory.createVehicle("UP78 AB 1765", VehicleType.BIKE);
        Vehicle truck = VehicleFactory.createVehicle("UP78 BR 3755", VehicleType.TRUCK);

        // Park the vehicles
        ParkingTicket ticket1 = parkingLot.parkVehicle(car1);
        System.out.println("Fare: " + parkingLot.unparkVehicle(ticket1));
    }
}
