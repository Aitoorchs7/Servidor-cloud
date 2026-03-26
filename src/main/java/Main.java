public class Main {
    public static void main(String[] args) {
        CloudServer cloudServer = new CloudServer();
        FogNode fogNode = new FogNode(cloudServer);
        EdgeNode edgeNode = new EdgeNode(fogNode);

        System.out.println("========Simulación Cloud - Fog - Edge ========\n");

        edgeNode.sendData(5);

        cloudServer.showData();
        System.out.println("Alertas detectadas en FOG: "+ fogNode.getAlertCount());
    }
}
