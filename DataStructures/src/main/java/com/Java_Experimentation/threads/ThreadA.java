package com.Java_Experimentation.threads;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/26/19
 */
public class ThreadA {
    public static void main(String[] args){
        ThreadB thr = new ThreadB();
        thr.start();
        ThreadB ths = new ThreadB();
        ths.start();

        synchronized (thr){
            try{
                System.out.println("waiting for b to complete");
                thr.wait();
            }catch (InterruptedException e) {
                System.out.println("total is: "+ thr.total);
            }
        }
    }
}
