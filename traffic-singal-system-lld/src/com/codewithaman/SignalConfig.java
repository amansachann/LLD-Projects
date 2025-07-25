package com.codewithaman;

public class SignalConfig {
    private final int redDuration;
    private final int greenDuration;
    private final int yellowDuration;

    public SignalConfig(int redDuration, int greenDuration, int yellowDuration) {
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }
}
