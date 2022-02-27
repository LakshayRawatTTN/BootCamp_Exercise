package Exercise6;

class Hello{


    public void hello(String name){
        System.out.println("Before synchronized block");
        synchronized (this) {
            for(int i =0; i < 3;i++) {
                System.out.println("Exercise6.Hello I am :" + name);
            }
        }
        System.out.println("after synchronized block");

    }
}

class MyThread extends Thread{

    Hello h;
    String name;
    MyThread(Hello h,String name){
        this.h = h;
        this.name =name;
    }
    public void run()
    {
        h.hello(name);
    }
}

public class Q3SynchronizedBlock {
    public static void main(String[] args){

        Hello h = new Hello();
        MyThread thread1 = new MyThread(h,"Lakshay");
        MyThread thread2 = new MyThread(h,"Ashish");
        thread1.start();
        thread2.start();

        try{thread1.join();
            thread2.join();}catch (Exception e){}

        //So when we run this program the code which is inside synchronized block will run
        //in a synchronous order but code outside it have no order.

    }
}
