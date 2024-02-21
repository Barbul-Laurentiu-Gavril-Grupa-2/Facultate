package tst;

public class ThreadCommandsDemo {
    public static void main(String[] args) {
        // Creating a new thread by extending Thread class
        MyThread thread1 = new MyThread();
        thread1.start(); // Starts the thread

        // Creating a new thread by implementing Runnable interface
        Runnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // Sleeping the main thread for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Notifying the waiting thread to wake up
        synchronized (runnable) {
            runnable.notify();
        }

        // Joining the threads
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is done.");
    }

    // Custom thread class extending Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread 1 is running.");

            // Sleeping the thread for 3 seconds
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 1 is done.");
        }
    }

    // Custom Runnable implementation
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread 2 is running.");

            // Waiting for another thread to notify
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread 2 is done.");
        }
    }
}
