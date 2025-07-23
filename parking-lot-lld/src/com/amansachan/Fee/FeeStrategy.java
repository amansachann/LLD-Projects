package com.amansachan.Fee;

import com.amansachan.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
