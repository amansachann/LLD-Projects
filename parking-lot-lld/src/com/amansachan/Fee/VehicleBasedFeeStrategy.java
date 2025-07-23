package com.amansachan.Fee;

import com.amansachan.ParkingTicket;
import com.amansachan.Vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    @Override
    public double calculateFee(ParkingTicket ticket) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime parkingDateTime = ticket.getParkingDateTime();
        ticket.setExitDateTime(currentDateTime);
        Duration duration = Duration.between(parkingDateTime, currentDateTime);
        double hours = duration.toHours();
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        if(vehicleType == VehicleType.CAR) {
            return hours * 2.5;
        } else if(vehicleType == VehicleType.BIKE) {
            return hours * 1.5;
        } else if(vehicleType == VehicleType.TRUCK) {
            return hours * 5;
        } else {
            throw new RuntimeException("Cannot calculate fee");
        }
    }
}
