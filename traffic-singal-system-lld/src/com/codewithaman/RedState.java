package com.codewithaman;

public class RedState implements SignalState {
    @Override
    public void switchToNext(TrafficSignalController context) {
        System.out.println("Switching from RED to GREEN");
        context.setState(new GreenState());
        context.startTimer(context.getConfig().getGreenDuration());
    }

    @Override
    public String getName() {
        return "RED";
    }
}
