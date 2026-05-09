package com.devops;
public class App {
    public static void main(String[] args) {
        System.out.println("Hello from Jenkins CI/CD Pipeline!");
        while (true) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                // Restore interrupt status and break loop
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
