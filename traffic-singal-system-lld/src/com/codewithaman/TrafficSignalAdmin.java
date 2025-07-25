package com.codewithaman;

public class TrafficSignalAdmin {
    public static void main(String[] args) {
        SignalConfig config = new SignalConfig(5, 5, 2);
        TrafficSignalController controller = new TrafficSignalController(config, Direction.NORTH);
        controller.start();

        // Manual override after 8 seconds
        new Thread(()->{
            try {
                Thread.sleep(8000);
                controller.overrideState(new GreenState());
                Thread.sleep(4000);
                controller.resumeAutoMode();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
