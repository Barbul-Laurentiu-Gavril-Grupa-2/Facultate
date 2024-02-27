public class FirC extends Thread{
    Resursa r;
    FirC(Resursa r){
        this.r = r;
    }
    public void run(){
        int i;
        for(i = 1;i<=10;i++) {
            r.scrie(i);
            System.out.println("Am citit " + r.citit());
        }
    }
}

