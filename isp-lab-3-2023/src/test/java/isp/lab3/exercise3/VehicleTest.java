package isp.lab3.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    @Test
    public void testToString() {
        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 150, 'B');
        String expected1 = "Dacia (Logan) speed 150 fuel type B";
        assertEquals(expected1, vehicle1.toString());

        Vehicle vehicle2 = new Vehicle("Tesla", "Model S", 200, 'D');
        String expected2 = "Tesla (Model S) speed 200 fuel type D";
        assertEquals(expected2, vehicle2.toString());
    }
}