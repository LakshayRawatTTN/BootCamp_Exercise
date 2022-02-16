package Exercise1;

import java.util.Scanner;

public class QuestionThree {

    static double areaOfCircle(double r){

        return 3.14*r*r;

    }

    static double circumferenceOfCircle(double r){
        return 2*3.14*r;

    }

    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter radius");
        double radius = sc.nextDouble();

        System.out.println("Enter your choice");
        System.out.println("1. Calculate Area of Circle"
        +"2. Calculate Circumference of a Circle"
        +"3. Exit.");

        int choice = sc.nextInt();

        switch(choice){

            case 1:
                System.out.println(areaOfCircle(radius));

                break;

            case 2:
                System.out.println(circumferenceOfCircle(radius));
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid Choice");


        }

    }

}
