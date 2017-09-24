package com.Java_Experimentation.JavaSeven;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/21/17
 */
public class ThreadExp {
    public static void main(String[] args){

        RunnableThread runThread = new RunnableThread(5);
        Thread thread1 = new Thread(runThread);
        Thread thread2 = new Thread(runThread);
        Thread thread3 = new Thread(runThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class RunnableThread implements Runnable {
    private int value =0;

    public RunnableThread(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"value from each thread: "+value++);
    }
}
