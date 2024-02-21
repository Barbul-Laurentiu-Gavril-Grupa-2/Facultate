package isp.lab2.Exercise6WordGuess;

import java.util.Random;
import java.util.Scanner;

public class Exercise6WordGuess {
    private static final int MAX_TRIES = 7;

    public static int countOccurrence(char c, char[] cuvant) {
        int numar = 0;
        for (char litera : cuvant) {
            if (Character.toLowerCase(litera) == Character.toLowerCase(c)) {
                numar++;
            }
        }
        return numar;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] cuvinte = {"Ana", "Tata", "Maria", "Dan", "Popescu", "Alexia"};
        int indiceCuvant = random.nextInt(cuvinte.length);
        String cuvantDeGhicit = cuvinte[indiceCuvant];
        char[] litereGhicate = new char[cuvantDeGhicit.length()];
        int incercari = 0;

        while (incercari < MAX_TRIES) {
            System.out.println("Introduceti o litera:");
            char litera = scanner.nextLine().charAt(0);
            int aparitii = countOccurrence(litera, cuvantDeGhicit.toCharArray());

            if (aparitii > 0) {
                System.out.println("Litera '" + litera + "' apare de " + aparitii + " ori in cuvant.");

                // Actualizeaza array-ul litereGhicate cu pozitiile corecte ale literelor
                for (int i = 0; i < cuvantDeGhicit.length(); i++) {
                    if (Character.toLowerCase(cuvantDeGhicit.charAt(i)) == Character.toLowerCase(litera)) {
                        litereGhicate[i] = cuvantDeGhicit.charAt(i);
                    }
                }
            } else {
                System.out.println("Litera '" + litera + "' nu se afla in cuvant. Mai aveti " + (MAX_TRIES - incercari - 1) + " incercari.");
                incercari++;
            }

            System.out.println("Cuvant ghicit pana acum: " + new String(litereGhicate));
            System.out.println();

            if (cuvantDeGhicit.equalsIgnoreCase(new String(litereGhicate))) {
                System.out.println("Felicitari! Ati ghicit cuvantul corect: " + cuvantDeGhicit);
                break;
            }
        }

        if (incercari == MAX_TRIES) {
            System.out.println("Sfarsit joc! Nu ati reusit sa ghiciti cuvantul. Cuvantul corect era: " + cuvantDeGhicit);
        }
    }
}