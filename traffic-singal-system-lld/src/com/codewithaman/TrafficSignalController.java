package com.codewithaman;

public class TrafficSignalController {
    private SignalState currentState;
    private SignalConfig config;
    private Direction direction;
    private boolean isManual;

    public TrafficSignalController(SignalConfig config, Direction direction) {
        this.config = config;
        this.direction = direction;
        this.currentState = new RedState();
        this.isManual = false;
    }

    public SignalConfig getConfig() {
        return config;
    }

    public SignalState getCurrentState() {
        return currentState;
    }

    public void setState(SignalState state) {
        this.currentState = state;
    }

    public void startTimer(int duration) {
        if(!isManual) {
            System.out.println("State: " + this.currentState.getName() + " for " + duration + " seconds.");
            new Thread(() -> {
                try {
                    Thread.sleep(duration * 1000L);
                    currentState.switchToNext(this);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void overrideState(SignalState state) {
        isManual = true;
        this.currentState = state;
        System.out.println("[MANUAL MODE] State for " + this.direction + " set to: " + state.getName());
    }

    public void resumeAutoMode() {
        isManual = false;
        System.out.println("[AUTO MODE] Resumed for: " + this.direction);
        startTimer(config.getRedDuration());
    }

    public void start() {
        System.out.println("Starting signal for direction: " + direction);
        startTimer(config.getRedDuration());
    }
}
