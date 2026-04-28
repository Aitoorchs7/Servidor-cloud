package main.java;

public class SensorData {

    private final String deviceId;
    private final double temperatura;

    public SensorData(String devideId, double temperatura) {
        this.deviceId = devideId;
        this.temperatura = temperatura;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "Device: "+deviceId+", Temp: "+String.format("%.2f", temperatura);
    }
}
