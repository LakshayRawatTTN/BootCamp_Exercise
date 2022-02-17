/*Q5) Create a class named Employee with fields firstname,lastname,age and designation. 
The class should:

    have all types of constructors to initialize the object
    class should also have setter methods to update a particular field
    Override its toString method to display a meaningful message using all these fields.*/


package Exercise1;

class Employee{
    String FirstName;
    String LastName;
    int Age;
    String Designation;

    public Employee(){
        FirstName = "DefaultName";
        LastName = "DefaultLastName";
        Age = 20;
        Designation = "Developer";
    }
    public Employee(String FirstName,String LastName,int Age,String Designation){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.Designation = Designation;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName){
        LastName = lastName;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setDesignation(String designation){
        Designation = designation;
    }

    @Override
    public String toString(){
        return "Hello I am "+ this.FirstName+" "+this.LastName +" and My age is "+this.Age+" I am "+this.Designation;
    }

}

public class QuestionFive {
    public static void main(String[] args){

        //object 1
        Employee e1 = new Employee();
        System.out.print(e1.FirstName+" ");
        System.out.print(e1.LastName+" ");
        System.out.print(e1.Age+" ");
        System.out.print(e1.Designation+"");
        System.out.println();

        //object 2
        Employee e2 = new Employee("Lakshay","Rawat",21,"Java Developer");
        System.out.print(e2.FirstName+" ");
        System.out.print(e2.LastName+" ");
        System.out.print(e2.Age+" ");
        System.out.print(e2.Designation+" ");
        System.out.println();

        //using Setters to set name
        e1.setFirstName("Ashish");
        e1.setLastName("Gupta");
        e1.setAge(21);
        e1.setDesignation("Java Developer");

        System.out.print(e1.FirstName+" ");
        System.out.print(e1.LastName+" ");
        System.out.print(e1.Age+" ");
        System.out.print(e1.Designation+" ");
        System.out.println();

        //toString method
        System.out.println(e1);
        System.out.println(e2);



    }
}
