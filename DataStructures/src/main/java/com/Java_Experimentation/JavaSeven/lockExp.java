package com.Java_Experimentation.JavaSeven;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/24/17
 */
public class lockExp {

    public static void main(String[] args){

    }
}

class Synchronizer implements Runnable {
    Lock lock = new ReentrantLock();

    public void doSynchronized() throws InterruptedException{
        this.lock.lock();
        System.out.println("locked");
        Thread.sleep(2000);
        this.lock.unlock();
    }

    @Override
    public void run() {

    }
}
