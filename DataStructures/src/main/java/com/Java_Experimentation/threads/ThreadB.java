package com.Java_Experimentation.threads;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/26/19
 */
public class ThreadB extends Thread{
    int total =0;

    public void run(){
        System.out.println("Entering the run method");
        synchronized (this){
            for(int i=0;i<100; i++){
                total += i;
                System.out.println("value: "+total + " "+ Thread.currentThread().getName());
            }
            notify();
        }
        System.out.println("Exiting the run method");
    }
}
