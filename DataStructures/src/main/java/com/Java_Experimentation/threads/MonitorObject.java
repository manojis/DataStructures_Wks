package com.Java_Experimentation.threads;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/27/19
 */
public class MonitorObject {
    public static void main(String[] args){
        Object chain = new Object();
        MonitorObject thiss = new MonitorObject();
        synchronized (thiss) {
            try {
                chain.wait(2000);
                System.out.println("entering the this log");
            } catch (InterruptedException e) {
                System.out.println("entering the catch exception");
            }
        }
    }
}
