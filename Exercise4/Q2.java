package Exercise4;

import java.awt.*;

interface MyInterface{
    int Operation(int a, int b);
}

class Functions{


    static int multiply(int a,int b){

         return a*b;

    }


}

public class Q2 {

    public static void main(String[] args){

        MyInterface myInterface = Functions::multiply;
        System.out.println(myInterface.Operation(2,3));

        MyInterface add = (a,b)->a+b;
        System.out.println(add.Operation(2,2));

        MyInterface sub = (a,b)->a-b;
        System.out.println(sub.Operation(2,2));



    }

}
