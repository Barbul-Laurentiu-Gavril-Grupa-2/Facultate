public class Fir_de_executie extends Thread{
    int pas;
    private static  int s=0;
    Fir_de_executie(int pas) {
        this.pas = pas;
    }
    static int sum;
        @Override
        public void run()
        {
            for (int i = 0; i <= 50; i++) {
                s = s+pas;
            }
            System.out.println("s" + getName() + "=" + s);

        }
    public static int getValue() {
        return s;
    }

    public static void main(String[] args) throws InterruptedException {
        Fir_de_executie F1 = new Fir_de_executie(2);
        Fir_de_executie F2 = new Fir_de_executie(3);
        Fir_de_executie F3 = new Fir_de_executie(4);
        F1.start();
        F2.start();
        F3.start();

        F3.setPriority(10);
        F1.join();
        F2.join();
        F3.join();
        System.out.println(F1.getPriority());
        System.out.println(F2.getPriority());
        System.out.println(F3.getPriority());
        System.out.println(F1.s+F2.s+F3.s);
    }
}
