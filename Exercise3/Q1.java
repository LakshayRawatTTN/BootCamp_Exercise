//1) Write Java code to define List .
// Insert 5 floating point numbers in List, and using an iterator,
// find the sum of the numbers in List.

package Exercise3;


import java.util.*;


public class Q1 {
    public static void main(String[] args){

        float sum = 0;
        Scanner sc = new Scanner(System.in);

        //Creating an arraylist
        List<Float> list = new ArrayList<Float>();
        System.out.println("Enter five floating numbers");

        for(int i = 0; i  < 5; i++){
            float f = sc.nextFloat();
            list.add(f);
        }

        //Iterator
        Iterator<Float> it = list.iterator();

        while(it.hasNext()){

            sum += it.next();

        }
        System.out.println("Sum of all float numbers : "+sum);
    }
}
