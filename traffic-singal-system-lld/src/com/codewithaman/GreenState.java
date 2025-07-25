package com.codewithaman;


public class GreenState implements SignalState {

    @Override
    public void switchToNext(TrafficSignalController context) {
        System.out.println("Switching from GREEN to YELLOW");
        context.setState(new YellowState());
        context.startTimer(context.getConfig().getYellowDuration());
    }

    @Override
    public String getName() {
        return "GREEN";
    }
}
