package aut.isp.lab4.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        AquariumController Test1 = new AquariumController();
        Test1.getLightsController().setEndStartTime(2.2F);
        Test1.setFeedingTime(2);
        int ok = 0;
        for (float i = 0; i <= 24 && ok < 2; i += 0.1) {
            System.out.println("Current time: " + i);
            Test1.setCurentTime(i);
            if ((i * 10) % 10 >= 6) {
                i = (int) i + 1;
                i-=0.1;
            }
            if (i >= 24) {
                ok++;
                i = 0;
            }
        }


    }
}
