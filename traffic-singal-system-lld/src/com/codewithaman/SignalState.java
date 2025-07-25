package com.codewithaman;

public interface SignalState {
    void switchToNext(TrafficSignalController context);
    String getName();
}
