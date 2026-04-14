package main.java;

import java.util.Random;

public class EdgeNode {
    private final int id; // Nuevo atributo de ID
    private final FogNode fogNode;
    private final Random random = new Random();

    public EdgeNode(int id, FogNode fogNode) {
        this.id = id;
        this.fogNode = fogNode;
    }

    public void sendData(int totalReadings) {
        for(int i = 1; i <= totalReadings; i++) {
            // Comprobación DÍA 7: Si ya llegamos a 20, dejamos de tomar temperaturas.
            if (fogNode.getAlertCount() >= 20) {
                break; 
            }

            double temperature = 20 + random.nextDouble() * 15;
            // Identificador que cumple el DÍA 14 (mostrando número de fog y edge)
            String devId = "Fog-" + fogNode.getId() + "_Edge-" + this.id;
            
            SensorData data = new SensorData(devId, temperature);
            System.out.println("[EDGE " + this.id + "] Enviando lectura " + i + ": " + data);
            
            fogNode.processData(data);
            System.out.println();
        }
    }
}
