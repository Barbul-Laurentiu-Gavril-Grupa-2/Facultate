package isp.lab10.raceapp;

import javax.swing.*;

public class RaceApp {
    public static void main(String[] args) {
        SemaphorePanel semaphorePanel = new SemaphorePanel();
        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        CarRace carRace = new CarRace(semaphoreThread);

        JFrame frame = new JFrame("Race App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(semaphorePanel);
        frame.pack();
        frame.setVisible(true);

        semaphoreThread.start();
        try {
            semaphoreThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        frame.setVisible(false);
        carRace.start();

        try {
            semaphoreThread.join(); // Wait for the semaphore thread to finish execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}