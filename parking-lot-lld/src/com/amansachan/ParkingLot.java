package com.amansachan;

import com.amansachan.Fee.FeeStrategy;
import com.amansachan.ParkingSpot.ParkingSpot;
import com.amansachan.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    FeeStrategy feeStrategy;
    private static ParkingLot INSTANCE;

    private ParkingLot() {
        this.parkingFloors = new ArrayList<>();
        this.feeStrategy = null;
    }

    private static class ParkingLotSingleton {
        private static final ParkingLot INSTANCE = new ParkingLot();
    }

    public static ParkingLot getInstance() {
        return ParkingLotSingleton.INSTANCE;
    }


    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    // methods to park and unpark the vehicles
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for(ParkingFloor floor : parkingFloors) {
            for(ParkingSpot spot : floor.getParkingSpots()) {
                if(!spot.isOccupied()) {
                    ParkingTicket ticket = new ParkingTicket(floor.getFloorNumber(), spot, vehicle);
                    spot.setOccupied(true);
                    spot.setVehicle(vehicle);
                    ticket.displayParkingTicketInfo();
                    return ticket;
                }
            }
        }
        System.out.println("No Parking Spots Available.");
        return null;
    }

    public double unparkVehicle(ParkingTicket ticket) {
        ParkingSpot spot = ticket.getParkingSpot();
        spot.setOccupied(false);
        spot.setVehicle(null);
        double fare = feeStrategy.calculateFee(ticket);
        ticket.displayParkingTicketInfo();
        return fare;
    }
}
