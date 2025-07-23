package com.amansachan.Fee;

import com.amansachan.ParkingTicket;
import com.amansachan.Vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlatRateStrategy implements FeeStrategy{
    @Override
    public double calculateFee(ParkingTicket ticket) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        ticket.setExitDateTime(currentDateTime);
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        if(vehicleType == VehicleType.CAR) {
            return 25;
        } else if(vehicleType == VehicleType.BIKE) {
            return 15;
        } else if(vehicleType == VehicleType.TRUCK) {
            return 40;
        } else {
            throw new RuntimeException("Cannot calculate fee");
        }
    }
}
