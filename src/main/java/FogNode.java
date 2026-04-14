package main.java;

public class FogNode {
    private final int id; 
    private final CloudServer cloudServer;
    private int alertCount;

    public FogNode(int id, CloudServer cloudServer) {
        this.id = id;
        this.cloudServer = cloudServer;
        this.alertCount = 0;
    }

    public void processData(SensorData data) {
        System.out.println("[FOG " + this.id + "] Dato recibido: " + data);
        
        if (alertCount < 20) {
            if (data.getTemperature() > 30) {
                alertCount++;
                System.out.println("[FOG " + this.id + "] Alerta: temperatura alta. (Alertas actuales: " + alertCount + ")");
                
                if(alertCount == 20) {
                    System.out.println(">>> [FOG " + this.id + "] Ha alcanzado el LÍMITE de 20 temperaturas altas. Dejará de tomar datos. <<<");
                }
            } else {
                System.out.println("[FOG " + this.id + "] Temperatura normal");
            }
            // Guardamos en el cloud independientemente de si es alta o no (mientras no pase de 20 alertas)
            cloudServer.saveData(data);
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