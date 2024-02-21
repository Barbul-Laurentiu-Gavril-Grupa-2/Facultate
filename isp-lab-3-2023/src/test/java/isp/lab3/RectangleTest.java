package isp.lab3;

import isp.lab3.exercise2.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void testDefaultConstructor() {
        Rectangle rectangle = new Rectangle();

        // Test getLength() method
        assertEquals(2, rectangle.getLength());

        // Test getWidth() method
        assertEquals(1, rectangle.getWidth());

        // Test getColor() method
        assertEquals("red", rectangle.getColor());

        // Test getPerimeter() method
        assertEquals(6, rectangle.getPerimeter());

        // Test getArea() method
        assertEquals(2, rectangle.getArea());
    }

    @Test
    public void testOverloadedConstructor() {
        Rectangle rectangle = new Rectangle(5, 3, "blue");

        // Test getLength() method
        assertEquals(5, rectangle.getLength());

        // Test getWidth() method
        assertEquals(3, rectangle.getWidth());

        // Test getColor() method
        assertEquals("blue", rectangle.getColor());

        // Test getPerimeter() method
        assertEquals(16, rectangle.getPerimeter());

        // Test getArea() method
        assertEquals(15, rectangle.getArea());
    }
}

