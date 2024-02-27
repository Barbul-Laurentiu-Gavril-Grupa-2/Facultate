import java.util.Scanner;

public class Calcul {
    public static void main(String[] args) {
        int i[] = new int[2];
        int j[] = new int[2];

        Scanner print = new Scanner(System.in);
        System.out.println("Introduceti primul numar (partea reala):");
        i[0] = print.nextInt();
        System.out.println("Introduceti primul numar (partea imaginara): ");
        i[1] = print.nextInt();
        System.out.println(i[0] +" + " + i[1] + "i");

        System.out.println("Introduceti primul numar (partea reala):");
        j[0] = print.nextInt();
        System.out.println("Introduceti primul numar (partea imaginara): ");
        j[1] = print.nextInt();
        System.out.println(j[0] +" + " + j[1] + "i");
        System.out.println("Suma " + i[0]+j[0] +" + " + i[1]+j[1] + "i");

    }
}
