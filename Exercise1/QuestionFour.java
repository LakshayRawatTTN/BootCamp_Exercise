/*Q4) Create a two dimensional array of integers and display:

    sum of all elements of each column
    sum of all elements of each row*/


package Exercise1;

import java.util.Scanner;

public class QuestionFour {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rows and Column respectively");

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        int rowSum = 0,colSum = 0;

        //2D array user input
        for(int i = 0; i < row;i++){
            for(int j = 0; j < col;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //Printing 2D array
        for(int i = 0; i < row;i++){
            for(int j = 0; j < col;j++){

                System.out.print(arr[i][j]+" ");

            }
            System.out.println();

        }


        //Calculating sum of each row
        for(int i = 0; i < row;i++){
            for(int j = 0; j < col;j++){
                rowSum += arr[i][j];
            }
            System.out.println("Sum of row "+i+"="+rowSum);
            rowSum = 0;
        }

        //Calculating sum of each column
        for(int j = 0; j < col;j++){
            for(int i = 0; i < arr[0].length;i++){
                colSum += arr[i][j];
            }
            System.out.println("Sum of col "+j+"="+colSum);
            colSum = 0;
        }

    }
}
