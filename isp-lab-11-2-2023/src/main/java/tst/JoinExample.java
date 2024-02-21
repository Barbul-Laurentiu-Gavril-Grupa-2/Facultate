package tst;

public class JoinExample {
    public static void main(String[] args) {
        Thread thread1 = new MyThread("Thread 1");
        Thread thread2 = new MyThread("Thread 2");

        // Start both threads
        thread1.start();
        try {
            // Wait for thread1 to complete
            thread1.join();
            thread2.start();
            // Wait for thread2 to complete with a timeout of 2000 milliseconds
            thread2.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is done.");
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + " - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(getName() + " is done.");
        }
    }
}

