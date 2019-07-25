package com.Java_Experimentation.threads;

public class Runnable_code implements Runnable {
    public void run(){
        for(int x=1; x<4; x++){
            System.out.println("Run by: " + Thread.currentThread().getName());
            try{
                System.out.println("Entering thread for try sleep: "
                        +Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
