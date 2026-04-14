package main.java;

import java.util.ArrayList;
import java.util.List;

public class CloudServer {
    private final List<SensorData> dataList = new ArrayList<>();

    public void saveData(SensorData data) {
        dataList.add(data);
        System.out.println("[CLOUD] Dato guardado: " + data);
    }

    public void showData() {
        double sum = 0;
        double average;

        System.out.println("\n========= [CLOUD] HISTORIAL DE DATOS =========");

        if(dataList.isEmpty()) {
            System.out.println("No hay datos guardados");
            return;
        }

        for(SensorData data : dataList){
            System.out.println(data);
            sum += data.getTemperature();
        }

        average = sum / dataList.size();
        System.out.println("----------------------------------------------");
        System.out.println("Total de datos almacenados: " + dataList.size());
        System.out.println("Media total de temperaturas: " + String.format("%.2f", average));
    }
}