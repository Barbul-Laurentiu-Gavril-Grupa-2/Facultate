public class Main {
    public static void main(String[] args) {
        Resursa resursa = new Resursa();
                FirS fs= new FirS(resursa);
                FirC fc= new FirC(resursa);
                fs.start();
                fc.start();
    }
}
