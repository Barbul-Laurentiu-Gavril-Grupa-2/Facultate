package isp.lab3;

import isp.lab3.exercise1.Tree;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void testGrow() {
        Tree tree = new Tree();

        // Test grow() method with a positive number of meters
        tree.grow(5);
        assertEquals(20, tree.getHeight());

        // Test grow() method with zero meters (should not change the height)
        tree.grow(0);
        assertEquals(20, tree.getHeight());

        // Test grow() method with a negative number of meters (should not change the height)
        tree.grow(-3);
        assertEquals(20, tree.getHeight());
    }

    @Test
    public void testToString() {
        Tree tree = new Tree();
        String expected = "Exercise1{height=15}";
        assertEquals(expected, tree.toString());
    }
}
