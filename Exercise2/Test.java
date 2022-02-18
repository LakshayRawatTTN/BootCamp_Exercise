package Exercise2;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

//bank class
    class Bank{

       protected double rateOfInterest;
       protected String Name;
       protected int balance = 0;
       protected String acc_no = "";
       TYPE accType;

       //constructor
       public Bank(){

           rateOfInterest = 0.0;
           Name = "BANK";
       }

       //get details of bank
        public void getDetails(){
            System.out.println("BANK: "+this.Name+" Rate Of Interest: "+this.rateOfInterest);
        }

        //
        public void printDetails(){
           System.out.println("Your bank is "+Name+", Your balance is"+balance+", Your account no. ="+acc_no);
        }

        //adding amount


        public void addAmt(int amt){




           Random r = new Random();
            int number = r.nextInt(100);
           acc_no = Name+number;
           balance +=amt;


        }

        //deducting amount
        public void withDraw(int wAmt){

            Scanner sc = new Scanner(System.in);
            System.out.println("From which you want to deduct 1.SAVING 2.CURRENT");
            int i = sc.nextInt();
            int flag = 0;
           switch (i){
               case 1:
                   accType = TYPE.SAVINGS;
                   break;
               case 2:
                   accType = TYPE.CURRENT;
                   break;
               default:
                   System.out.println("Wrong choice");
            }

           try{
               if(balance < wAmt){
                   flag = -1;
                   throw new InsufficientAmountException();
               }

               int beforeWithDrawl = balance;
               balance = balance - wAmt;
               System.out.println("Amount deducted from "+accType+" account & your current balance: "+balance);
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
               LocalDateTime now = LocalDateTime.now();
               try{
                   FileWriter my=new FileWriter("TransactionDetail.txt");
                   my.write("The account number is:"+acc_no +"\n");
                   my.write("The amount in the account :"+beforeWithDrawl+"\n");
                   my.write("The amount withdrawl is :"+wAmt+"\n");
                   if(flag==0){
                       my.write("The available amount in the account is :"+balance+"\n");
                       my.write("Transaction successful"+"\n");
                       my.write("Transaction time"+now+"  and date:"+dtf+"\n");


                   }
                   else
                       my.write("Transaction cancelled");
                   my.close();


               }
               catch(IOException e){
                   System.out.println("An error occured");
               }


           }
           catch (InsufficientAmountException e){
               System.out.println(e);
           }
        }


        enum TYPE{
           CURRENT,SAVINGS;
        }

        //open account


    }
    class InsufficientAmountException extends Exception{

        InsufficientAmountException(){
        super("Insufficient Balance to withdraw this amount");
        }

    }






//ICICI class
    class ICICI extends Bank{

    public ICICI(){
        super.Name = "ICICI";
        super.rateOfInterest=2.5;

    }

    }

    //SBI class
    class SBI extends Bank{

       public SBI(){


            super.Name = "SBI";
            super.rateOfInterest=3.5;

        }


    }

    //BOI class
    class BOI extends Bank{

        public BOI(){
            super.Name = "BOI";
            super.rateOfInterest=4.5;

        }

    }


    //Main class
    public class Test {

        public static void main(String[] args){

            ICICI user1 = new ICICI();
            user1.getDetails();

            SBI user2 = new SBI();
            user2.getDetails();

            BOI user3 = new BOI();
            user3.getDetails();

            //Adding amount
            user1.addAmt(200);

            //Deducting amount
            user1.withDraw(100);

            //printing balance
            System.out.println(user1.balance);

            //deducting amount greater than balance
            user1.withDraw(101);

            //printing user detail
            user1.printDetails();





            }



    }
