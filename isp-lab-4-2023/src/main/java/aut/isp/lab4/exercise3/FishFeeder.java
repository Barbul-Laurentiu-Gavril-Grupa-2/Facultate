package aut.isp.lab4.exercise3;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals=14;
    public void feed(){
        if(meals>1) {
            this.meals -= 1;
            System.out.println("S-a consumat o unitate de mancare.. Au ramas: "+this.meals +" unitati de mancare");
        }
        else     System.out.println("Nu mai este de mancare!");

    }
    private void fillup() {
    this.meals=14;
        System.out.println("S-a resetat mancarea\n");
    }

    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", mode='" + model + '\'' +
                ", meals=" + meals +
                '}';
    }
}
