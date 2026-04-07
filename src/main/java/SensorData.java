package main.java;

public class SensorData {

    private final String deviceId;
    private final double temperature;

    public SensorData(String devideId, double temperature) {
        this.deviceId = devideId;
        this.temperature = temperature;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Device: "+deviceId+", Temp: "+String.format("%.2f", temperature);
    }
}
