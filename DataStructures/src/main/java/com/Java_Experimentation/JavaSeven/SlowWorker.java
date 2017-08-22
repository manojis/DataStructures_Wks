package com.Java_Experimentation.JavaSeven;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/20/17
 */
public class SlowWorker {

    public SlowWorker(){

    }
    public String doWork(){
        System.out.println("************engaging the doWork********* "+ new java.util.Date());
        try {
            Thread.sleep(10000);
            System.out.println("************going through the sleep scenario**************** "+ new java.util.Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }
    /*public static void main(String[] args){
        SlowWorker sw = new SlowWorker();
        System.out.println("started with the thread "+ new java.util.Date());
        sw.doWork();
        System.out.println("ended with the thread "+ new java.util.Date());

    }*/
}
