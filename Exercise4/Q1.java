//Q1) Write the following a functional interface and implement it using lambda:
//
//    First number is greater than second number or not Parameter (int ,int ) Return boolean
//    Increment the number by 1 and return incremented value Parameter (int) Return int
//    Concatination of 2 string Parameter (String , String ) Return (String)
//    Convert a string to uppercase and return . Parameter (String) Return (String)

package Exercise4;


interface MyInterface1{

    boolean greaterThan(int a,int b);

}

interface MyInterface2{

    int incrementOne(int a);

}

interface MyInterface3{

    String concatination(String s1,String s2);

}

interface MyInterface4{

    String upperCase(String s1);

}

public class Q1 {

    public static void main(String[] args){

        MyInterface1 myInterface = (a,b) -> a>b;
        System.out.println(myInterface.greaterThan(5,6));

        MyInterface2 increment = a -> a+1;
        System.out.println(increment.incrementOne(2));

        MyInterface3 Concat = (a,b) -> a+b;
        System.out.println(Concat.concatination("Hello","Lakshay"));

        MyInterface4 Upper = a -> a.toUpperCase();
        System.out.println(Upper.upperCase("lakshay rawat"));



    }

}
