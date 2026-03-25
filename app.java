package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello from Jenkins and Docker!");
        System.out.println("Java Pipeline is running successfully.");
        System.out.println("---------------------------------------");
        
        // Keep the app running so the container doesn't immediately exit
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
