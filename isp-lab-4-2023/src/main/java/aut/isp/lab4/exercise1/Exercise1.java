package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        //create an object
        AquariumController apa= new AquariumController();
        apa.setCurentTime(12);
        String afis=apa.toString();
        System.out.println(apa.toString());
    }
}
