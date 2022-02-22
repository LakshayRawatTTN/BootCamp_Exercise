package Exercise4;

public class Q3 {

    public static void main(String[] args){

        Thread th =new Thread( () -> System.out.println("Hello I am thread, I am running"));
        th.run();



    }

}
