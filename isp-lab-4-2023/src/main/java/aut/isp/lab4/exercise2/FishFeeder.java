package aut.isp.lab4.exercise2;

public class FishFeeder {
    private String manufacturer;
    private String mode;
    private int meals=14;
    private void feed(){
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

    public void getInstance(int meals,String mode,String manufacturer)
    {
        this.meals=meals;
        this.mode=mode;
        this.manufacturer=manufacturer;
        this.fillup();
        this.feed();
        toString();
    }
    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", mode='" + mode + '\'' +
                ", meals=" + meals +
                '}';
    }
}
