package isp.lab3.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyPointTest {
    @Test
    public void testDistance() {
        MyPoint point1 = new MyPoint(1, 2, 3);
        MyPoint point2 = new MyPoint(4, 5, 6);

        // Test distance(int x, int y, int z)
        double distance1 = point1.Distance(4, 5, 6);
        assertEquals(5.196152422706632, distance1, 0.000001);

        // Test distance(MyPoint another)
        double distance2 = point1.Distance(point2);
        assertEquals(5.196152422706632, distance2, 0.000001);
    }
}