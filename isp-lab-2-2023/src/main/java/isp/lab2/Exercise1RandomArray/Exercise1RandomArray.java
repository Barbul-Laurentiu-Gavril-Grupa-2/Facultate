package isp.lab2.Exercise1RandomArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for( int i=0;i<n;i++)
            array[i]= random.nextInt(91) + 10;
        return array;
    }

    public static int[] findMaxAndMin(int[] array) {
    int[] mn = new int[2];
    mn[0]=array[0];
    mn[1]=0;
    int maxi = array.length;
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        for(int i=0;i< maxi;i++) {
            if (mn[0] >= array[i])
                mn[0] = array[i];
            if (mn[1] <= array[i])
                mn[1] = array[i];
        }
            return mn;
    }

    public static void main(String[] args) {

        Random random = new Random();

        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMaxAndMin(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
