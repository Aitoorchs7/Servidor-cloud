package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CloudServer cloudServer = new CloudServer();
        FogNode fogNode = new FogNode(cloudServer);
        EdgeNode edgeNode = new EdgeNode(fogNode);

        System.out.println("========Simulación Cloud - Fog - Edge ========\n");

        System.out.println("Escriba el número de datos que quiere registrar");
        int numData = sc.nextInt();
        edgeNode.sendData(numData);
        System.out.println(fogNode.getAlertCount());

        cloudServer.showData();
        System.out.println("Alertas detectadas en FOG: "+ fogNode.getAlertCount());
        sc.close();
    }
}
