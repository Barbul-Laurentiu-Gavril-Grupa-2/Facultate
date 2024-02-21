package isp.lab4.exercise3;

import java.util.ArrayList;
import java.util.List;

public class MonitoringService {
    private List<Sensor> sensors;

    public MonitoringService() {
        this.sensors = new ArrayList<>();
    }
    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }
    public double getAverageTemperature() {
        double sumTemperature = 0.0;
        int countTemperatureSensors = 0;

        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                TemperatureSensor temperatureSensor = (TemperatureSensor) sensor;
                sumTemperature += temperatureSensor.getTemperature();
                countTemperatureSensors++;
            }
        }

        if (countTemperatureSensors > 0) {
            return sumTemperature / countTemperatureSensors;
        } else {
            return 0.0; // Return a default value or handle the case when no temperature sensors are present
        }
    }

    public double getAverageAllSensors() {
        double sumSensorValues = 0.0;
        int countSensors = 0;

        for (Sensor sensor : sensors) {
             if (sensor instanceof PressureSensor) {
                PressureSensor pressureSensor = (PressureSensor) sensor;
                sumSensorValues += pressureSensor.getPressure();
            countSensors++;}
        }

        if (countSensors > 0) {
            return sumSensorValues / countSensors;
        } else {
            return 0.0; // Return a default value or handle the case when no sensors are present
        }
    }
}
