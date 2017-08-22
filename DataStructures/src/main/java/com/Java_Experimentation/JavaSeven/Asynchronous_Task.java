package com.Java_Experimentation.JavaSeven;

import java.util.concurrent.*;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/20/17
 */
public class Asynchronous_Task {

    public Asynchronous_Task(){

    }

    public static void main(String[] args){
        SlowWorker sw = new SlowWorker();
        ExecutorService ex = Executors.newFixedThreadPool(3);
        System.out.println("started with the thread "+ new java.util.Date());

        final Future fu = ex.submit(new Callable() {

            public Object call(){
                //sw.doWork();
                return sw.doWork();
            }
        });
        System.out.println("... try to do something while the work is being done....");

        try {
            System.out.println("... Inside the try statement....");
            System.out.println("... End of try statement...."+fu.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("ended with the thread "+ new java.util.Date());
        System.exit(0);
    }
}
