package Exercise6;//4) WAP to show usage of Callable and demonstrate how it is different from Runnable

import java.util.Random;
import java.util.concurrent.*;

public class Q4 {

    public static void main(String[] args){

        //Runnable does not return anything after thread is run.
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.submit(()->{
            Random r = new Random();
            int time = r.nextInt(5000);
            System.out.println("Thread start sleeping");
            try{Thread.sleep(time);}catch (Exception e){}
            System.out.println("Thread woke up");
        } );

        executorService1.shutdown();
        while(!executorService1.isTerminated()){}
        System.out.println("ExecutorService 1 closed");

        //using callable
        //Callable is used when ypu want to return a value from your thread
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        Future<Integer> future = executorService2.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random r = new Random();
                int time = r.nextInt(5000);
                System.out.println("Thread start sleeping");
                try{Thread.sleep(time);}catch (Exception e){}
                System.out.println("Thread woke up");
                return time;
            }
        });
        executorService2.shutdown();
        while(!executorService2.isTerminated()){}
        System.out.println("ExecutorService 2 closed");
        try {
            System.out.println("Slept for = "+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }



}
