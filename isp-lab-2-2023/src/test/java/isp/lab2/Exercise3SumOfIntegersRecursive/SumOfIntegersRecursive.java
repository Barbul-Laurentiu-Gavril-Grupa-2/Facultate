package isp.lab2.Exercise3SumOfIntegersRecursive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfIntegersRecursive {

    @Test
    public void testSumOfIntegers() {
        int n = 6;
        int expected = 21;
        int actual = Exercise3SumOfIntegersRecursive.sumOfIntegers(n);
        assertEquals(expected, actual);
    }
}
