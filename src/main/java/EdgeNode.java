package main.java;

import java.util.Random;

public class EdgeNode {
    private final FogNode fogNode;
    private final Random random = new Random();

    public EdgeNode (FogNode fogNode) {
        this.fogNode = fogNode;
    }

    public void sendData(int totalReadings){
        for(int i = 1; i <= totalReadings; i++){
            double temperature = 20 + random.nextDouble() * 15;
            SensorData data = new SensorData("sensor-1", temperature);
            System.out.println("[EDGE] Enviando lectura: "+ i + ": " + data);
            fogNode.processData(data);
            System.out.println();
        }
    }
}
