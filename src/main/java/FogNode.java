public class FogNode {
    private final CloudServer cloudServer;
    private int alertCount;

    public FogNode(CloudServer cloudServer) {
        this.cloudServer = cloudServer;
    }
    public void processData(SensorData data){
        System.out.println("[FOG] Dato recibido: "+data);
        if(alertCount <20) {
            if (data.getTemperature() > 30) {
                alertCount++;

                System.out.println("[FOG] Alerta: temperatura alta");
            } else {
                System.out.println("[FOG] Temperatura normal");
            }
            cloudServer.saveData(data);
        }
        else{
            System.out.println("[FOG] Límite de alertas alcanzado");
        }
    }
    public int getAlertCount() {
        return alertCount;
    }
    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }
}
