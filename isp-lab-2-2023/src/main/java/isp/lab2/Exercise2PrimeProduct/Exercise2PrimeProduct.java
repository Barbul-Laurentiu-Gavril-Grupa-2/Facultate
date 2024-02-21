package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    /**
     * This method should return the product of the first n prime numbers
     * @param n
     * @param m
     * @return
     */
    public static long getPrimeProduct(int n, int m) {
    long prod=1 ;
        for(int i=n+1;i<m;i++)
        {
            boolean ok=true;
            if(i%2==0&&i!=2)
                ok=false;
            for(int j=3;j<=(int)Math.sqrt(i)&&ok==true;j+=2)
                if(i%j==0)
                    ok=false;
            if(ok==true)
              prod *=i;
        }
        return prod;
    }


    /**
     * This method should read from the console a number
     * @return the number read from the console
     */
    public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {
        System.out.println("The product of the first 10 prime numbers is: " + getPrimeProduct(1, 10));
        System.out.println("The product of prime numbers between m and n: " + getPrimeProduct(readfromConsoleInt(), readfromConsoleInt()));
    }

}
