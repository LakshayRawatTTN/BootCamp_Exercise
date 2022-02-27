package Exercise6;//2) Use a singleThreadExecutor, newCachedThreadPool()
// and newFixedThreadPool() to submit a list of tasks and wait for completion of all tasks.

//1-pool
//1,2,3,,4,4,5,5,5,5,,6,6,,6,6,,,
//1000



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Workers implements Runnable{
    String name;

    public Workers(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("Work started : "+name +" by "+Thread.currentThread().getName());
        try{Thread.sleep(1000);}catch(Exception e){}
        System.out.println("Work Stopped : "+name);

    }
}


public class Q2 {

    public static void main(String[] args){

        //In this only single thread will do all the task and other queued task wait for the thread to complete the task.
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        for(int i = 1; i <=10;i++){
            Runnable runnable = new Workers(""+i);
            executorService1.execute(runnable);
        }
        executorService1.shutdown();
        while(!executorService1.isTerminated()){}
        System.out.println("Exercise6.Workers stooped working");


        //In this thread pool 5 threads are created which works concurrently.
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);

        for(int i = 1; i <=10;i++){
            Runnable runnable = new Workers(""+i);
            executorService2.execute(runnable);
        }
        executorService2.shutdown();
        while(!executorService2.isTerminated()){}
        System.out.println("Exercise6.Workers stooped working");



        //Cached Thread pool
        ExecutorService executorService3 = Executors.newCachedThreadPool();

        for(int i = 1; i <=10;i++){
            Runnable runnable = new Workers(""+i);
            executorService3.execute(runnable);
        }
        executorService3.shutdown();
        while(!executorService3.isTerminated()){}
        System.out.println("Exercise6.Workers stooped working");


    }

}
