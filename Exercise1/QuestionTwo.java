

package Exercise1;
import java.util.Scanner;

public class QuestionTwo {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter String");
        String str = sc.nextLine();

        while(!str.equals("XDONE")){

            sb.append(str+" ");
            str = sc.nextLine();



        }
        System.out.println(sb);

    }


}
