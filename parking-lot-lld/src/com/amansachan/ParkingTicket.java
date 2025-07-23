package com.amansachan;

import com.amansachan.ParkingSpot.ParkingSpot;
import com.amansachan.Vehicle.Vehicle;
import java.time.LocalDateTime;

public class ParkingTicket {
    private static int ticketNumberCount = 1;
    private int ticketNumber;
    private int floorNumber;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private LocalDateTime parkingDateTime;
    private LocalDateTime exitDateTime;

    public ParkingTicket(int floorNumber, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketNumber = ticketNumberCount++;
        this.floorNumber = floorNumber;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.parkingDateTime = LocalDateTime.now();
        this.exitDateTime = null;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getParkingDateTime() {
        return parkingDateTime;
    }

    public LocalDateTime getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(LocalDateTime exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    @Override
    public String toString() {
        return "ParkingTicket:\n" +
                "ticketNumber=" + ticketNumber +
                "\nfloorNumber=" + floorNumber +
                "\nparkingSpot=" + parkingSpot.toString() +
                "\nvehicle=" + vehicle.toString() +
                "\nparkingDateTime=" + parkingDateTime +
                "\nexitDateTime=" + exitDateTime +
                '}';
    }

    public void displayParkingTicketInfo() {
        System.out.println("Parking Ticket Info: " + this.toString());
    }
}
