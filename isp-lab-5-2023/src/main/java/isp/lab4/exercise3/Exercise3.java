package isp.lab4.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
    // Create MonitoringService object
    MonitoringService monitoringService = new MonitoringService();

    // Create TemperatureSensor objects
    TemperatureSensor livingRoomSensor = new TemperatureSensor();
    livingRoomSensor.setInstalLocation("Living Room");
    livingRoomSensor.setName("Living Room Sensor");
    livingRoomSensor.setTemperature(25.5);

    TemperatureSensor kitchenSensor = new TemperatureSensor();
    kitchenSensor.setInstalLocation("Kitchen");
    kitchenSensor.setName("Kitchen Sensor");
    kitchenSensor.setTemperature(23.8);

    TemperatureSensor bedroomSensor = new TemperatureSensor();
    bedroomSensor.setInstalLocation("Bedroom");
    bedroomSensor.setName("Bedroom Sensor");
    bedroomSensor.setTemperature(22.3);

    // Create PressureSensor objects
    PressureSensor livingRoomPressureSensor = new PressureSensor();
    livingRoomPressureSensor.setInstalLocation("Living Room");
    livingRoomPressureSensor.setName("Living Room Pressure Sensor");
    livingRoomPressureSensor.setPressure(1013.2);

    PressureSensor kitchenPressureSensor = new PressureSensor();
    kitchenPressureSensor.setInstalLocation("Kitchen");
    kitchenPressureSensor.setName("Kitchen Pressure Sensor");
    kitchenPressureSensor.setPressure(1012.5);

    PressureSensor bedroomPressureSensor = new PressureSensor();
    bedroomPressureSensor.setInstalLocation("Bedroom");
    bedroomPressureSensor.setName("Bedroom Pressure Sensor");
    bedroomPressureSensor.setPressure(1014.7);

    // Add sensors to the MonitoringService
    monitoringService.addSensor(livingRoomSensor);
    monitoringService.addSensor(kitchenSensor);
    monitoringService.addSensor(bedroomSensor);
    monitoringService.addSensor(livingRoomPressureSensor);
    monitoringService.addSensor(kitchenPressureSensor);
    monitoringService.addSensor(bedroomPressureSensor);

    // Get and display average temperature for all sensors
    double averageTemperature = monitoringService.getAverageTemperature();
    System.out.println("Average temperature for all sensors: " + averageTemperature);

    // Get and display average of all sensors
    double averageAllSensors = monitoringService.getAverageAllSensors();
    System.out.println("Average of all sensors: " + averageAllSensors);
}
}
