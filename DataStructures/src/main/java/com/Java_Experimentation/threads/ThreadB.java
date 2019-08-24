package com.Java_Experimentation.threads;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/26/19
 */
public class ThreadB extends Thread{
    int total =0;

    public ThreadB(int total){
        this.total = total;
    }

    public void run(){
        System.out.println("Entering the run method"+ Thread.currentThread().getName());
        synchronized (this){
            System.out.println("Entering the synchronized method"+ Thread.currentThread().getName());
            for(int i=0;i<100; i++){
                total += i;
                System.out.println("value: "+total + " "+ Thread.currentThread().getName());
            }
            notify();
        }
        System.out.println("Exiting the run method");
    }
}
