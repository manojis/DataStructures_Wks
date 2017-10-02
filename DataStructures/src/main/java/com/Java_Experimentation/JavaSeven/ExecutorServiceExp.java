package com.Java_Experimentation.JavaSeven;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/23/17
 */
public class ExecutorServiceExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> servicList= new ArrayList<>();

        /*for(int i=0;i<4;i++){
            System.out.println("inside the for loop");
            Future<Integer> result = executorService.submit(new taskService(3));
            servicList.add(result);
        }

        for(Future<Integer> res: servicList){
            System.out.println("value from get "+res.get()+ "; And Task done is " + res.isDone());
        }*/
        ExecutorService runEx = Executors.newFixedThreadPool(2);
        for(int i=0;i<4;i++){
            System.out.println("value of i: "+ i);
            runEx.submit( new runService());
        }
        /*BlockingQueue<Runnable> threadPool = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor tpExecutor = new ThreadPoolExecutor(20, 2000, 0L, TimeUnit.MILLISECONDS, threadPool);
        tpExecutor.prestartAllCoreThreads();
        for (int i = 0; i < 4; i++) {
            System.out.println("inside the for loop of ThreadPooolExecutor");
            tpExecutor.execute(new taskService());
        }*/
        System.out.println("About to execute shutdown ");
        runEx.shutdown();
    }
}
class taskService implements Callable<Integer> {
    private Integer number;
    public taskService(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }
}

class runService implements Runnable{

    @Override
    public void run() {
        System.out.println("inside the runService"+ Thread.currentThread().getName());
    }
}