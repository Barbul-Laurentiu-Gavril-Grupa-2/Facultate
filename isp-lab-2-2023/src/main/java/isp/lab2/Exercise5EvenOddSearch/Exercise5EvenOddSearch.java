package isp.lab2.Exercise5EvenOddSearch;

import java.util.Arrays;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        String[] nr= input.split(",");
        int[] numere = new int[4];
        int ok=1;
        int poz=-1;
        Arrays.fill(numere, 0);
        for(String token : nr)
        {
            poz++;
            int numar = Integer.parseInt(token);
            if(numar%2==0&&numar>numere[0])
            {numere[0]=numar;
                numere[1]=poz;
            }
            else if(numar%2!=0&&ok==1)
            {numere[2]=numar;
                numere[3]=poz;
                ok=0;
            }
            else if (numar%2!=0&&numar<numere[1])
            {  numere[2]=numar;
                numere[3]=poz;
            }
        }
        return numere;
    }

    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
