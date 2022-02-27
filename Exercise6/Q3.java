package Exercise6;//3) Use Synchronize method and synchronize block to
// enable synchronization between multiple threads trying to access method at same time.

public class Q3 {

    int num =0;
    public synchronized void increment(){
       num++;
    }

    public static void main(String[] args){

        Q3 q = new Q3();
        Thread t1 = new Thread(() -> {for(int i =0;i<1000;i++){ q.increment(); }});
        Thread t2 = new Thread(() -> {for(int i =0;i<1000;i++){ q.increment();}});
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Total increment :" +q.num);




    }

}
