package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CloudServer cloudServer = new CloudServer();
        
        // Listas para guardar nuestros nodos
        List<FogNode> fogs = new ArrayList<>();
        List<EdgeNode> edges = new ArrayList<>();

        // Creación de 5 Fogs y 5 Edges por cada Fog (25 Edges en total)
        for (int i = 1; i <= 5; i++) {
            FogNode newFog = new FogNode(i, cloudServer);
            fogs.add(newFog);
            
            for (int j = 1; j <= 5; j++) {
                EdgeNode newEdge = new EdgeNode(j, newFog);
                edges.add(newEdge);
            }
        }

        System.out.println("======== Simulación Cloud - Fog - Edge ========\n");
        System.out.println("Escriba el número MÁXIMO de datos que generará CADA Edge:");
        int numData = sc.nextInt();
        System.out.println("\n--- INICIANDO ENVÍO DE DATOS EN ORDEN ---\n");

        // Hacemos que cada Edge mande sus temperaturas en orden
        for (EdgeNode edge : edges) {
            edge.sendData(numData);
        }

        // Resumen Final
        cloudServer.showData();
        
        System.out.println("\n======== RESUMEN DE ALERTAS POR FOG ========");
        for (FogNode fog : fogs) {
            System.out.println("Fog " + fog.getId() + " - Alertas detectadas: " + fog.getAlertCount());
        }
        
        sc.close();
    }
}
