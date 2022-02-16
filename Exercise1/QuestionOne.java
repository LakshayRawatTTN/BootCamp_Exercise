/*Q1) Write a class with FirstName, LastName & age field. Print Firstname,
LastName & age using static block, static method & static variable respectively.
 */
package Exercise1;
import java.util.Scanner;

public class QuestionOne {


    static Scanner sc = new Scanner(System.in);

    static String FirstName ="Lakshay";

    //static block
    static {
        System.out.println(FirstName);
    }

    //static method
    static void LastName(String name){
        System.out.println(name);
    }

    //static variable
    static int age = 21;

    public static void main(String[] args){

        String name = "Rawat";

        //calling static method
        QuestionOne.LastName(name);

        //calling static variable
        System.out.println(QuestionOne.age);

    }

}
