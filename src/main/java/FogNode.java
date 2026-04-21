package main.java;

import java.util.ArrayList;
import java.util.List;

public class FogNode {
    private final int id;
    private final CloudServer cloudServer;
    private int alertCount;
    // NUEVO: Lista temporal para guardar los datos antes de enviarlos (Buffer)
    private final List<SensorData> dataBuffer;

    public FogNode(int id, CloudServer cloudServer) {
        this.id = id;
        this.cloudServer = cloudServer;
        this.alertCount = 0;
        this.dataBuffer = new ArrayList<>(); // Inicializamos el buffer
    }

    public void processData(SensorData data) {
        System.out.println("[FOG " + this.id + "] Dato recibido: " + data);
        
        if (alertCount < 20) {
            // 1. Comprobación de temperatura
            if (data.getTemperature() > 30) {
                alertCount++;
                System.out.println("[FOG " + this.id + "] Alerta: temperatura alta. (Alertas actuales: " + alertCount + ")");
                
                if(alertCount == 20) {
                    System.out.println(">>> [FOG " + this.id + "] Ha alcanzado el LÍMITE de 20 alertas. Dejará de tomar datos. <<<");
                }
            } else {
                System.out.println("[FOG " + this.id + "] Temperatura normal");
            }

            // 2. LÓGICA DEL DÍA 21/04: Almacenar en lotes de 5
            dataBuffer.add(data); // Añadimos el dato al buffer en lugar de enviarlo directo
            
            // Comprobamos si ya tenemos 5 datos guardados
            if (dataBuffer.size() == 5) {
                System.out.println("\n⏳ [FOG " + this.id + "] Lote de 5 datos completado. Procesando...");
                
                // Generamos la espera de procesamiento (2 segundos)
                try {
                    Thread.sleep(2000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // Tras la espera, enviamos los 5 datos al Cloud
                for (SensorData d : dataBuffer) {
                    cloudServer.saveData(d);
                }
                
                // Vaciamos la lista para prepararla para los siguientes 5 datos
                dataBuffer.clear();
                System.out.println("✅ [FOG " + this.id + "] Lote enviado al Cloud con éxito.\n");
            }
            
        } else {
            System.out.println("[FOG " + this.id + "] Límite de alertas (20) superado. Se ignora el dato.");
        }
    }

    public int getId() {
        return id;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }
}