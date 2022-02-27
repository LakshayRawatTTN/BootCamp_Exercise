package Exercise6;//1) Create and Run a Thread using Runnable Interface and Thread class and
// show usage of sleep and join methods in the created threads.

class MakingThread extends Thread{

    @Override
    public void run(){
        System.out.println("Exercise6.Hello I am thread running by extending Thread1 class and I am going to sleep");

        //sleep() method can be used to pause the execution of current thread
        // for specified time in milliseconds.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread1 woke up");
    }
}

public class Q1 implements Runnable {
    public  void hello(){

    }

    public static void main(String[] args) throws InterruptedException {

        MakingThread thread1 = new MakingThread();
        thread1.start();
        //The join method allows one thread to wait for the completion of another
        //here thread2 is waiting for completion of thread1.
     //   thread1.join();

        thread1.join();
        Q1 q = new Q1();
        Thread thread2 = new Thread(q);
        thread2.start();

    }

    @Override
    public void run() {
    System.out.println("Exercise6.Hello i am Thread2 running by implementing Runnanble Interface");
    }
}
