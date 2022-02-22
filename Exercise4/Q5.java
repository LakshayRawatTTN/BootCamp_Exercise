//Q5)Implement multiple inheritance with default method inside interface.

package Exercise4;



interface Company {
    default void display() {
        System.out.println("Company");
    }
}

class emp1 implements Company {


}

class emp2 implements Company {

    @Override
    public void display(){
        System.out.println("emp2");
    }

}


public class Q5  {

    public static void main(String[] args) {
        emp1 e1= new emp1();
        emp2 e2 = new emp2();
        e1.display();
        e2.display();

    }

}
