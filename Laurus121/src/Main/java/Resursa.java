public class Resursa {
    int res;
    synchronized public void scrie(int a){
        res = a;
        try {
            wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        }
    synchronized public int citit(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        return res;
    }
}
