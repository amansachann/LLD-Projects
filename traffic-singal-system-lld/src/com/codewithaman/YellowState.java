package com.codewithaman;

public class YellowState implements SignalState {
    @Override
    public void switchToNext(TrafficSignalController context) {
        System.out.println("Switching from GREEN to YELLOW");
        context.setState(new RedState());
        context.startTimer(context.getConfig().getRedDuration());
    }

    @Override
    public String getName() {
        return "YELLOW";
    }
}
