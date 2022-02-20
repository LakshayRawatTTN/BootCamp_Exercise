//2) Given the following class
//Employee class{ Double Age; Double Salary; String Name}
//        Design the class in such a way that the default sorting should work on firstname and lastname.
//Also, Write a program to sort Employee objects based on salary using Comparator.
package Exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

class Employee implements Comparable<Employee>, Comparator<Employee> {
    String Name;
    int Age;
    Double Salary;

    Employee(String FirstName, String LastName,int Age, Double Salary){

        this.Name = FirstName+LastName;
        this.Age = Age;
        this.Salary = Salary;

    }

    public Employee() {

    }

    @Override
    public String toString() {
        return Name +" "+Age+" "+Salary;
    }

    @Override
    public int compareTo(Employee e) {

        return Name.compareTo(e.Name);
    }

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.Salary < e2.Salary)
            return 1;
        else if(e1.Salary > e2.Salary)
            return -1;
        return 0;
    }
}

public class Q2 {

    public static void main(String[] args){

        Employee e1 = new Employee("Lakshay","Rawat",21,15200.00);

        Employee e2 = new Employee("Ashish","Gupta",21,15100.00);

        Employee e3 = new Employee("Komal","Rawat",21,15050.00);

        Employee e4 = new Employee("Govind","Kumar",21,15051.00);

        Employee e5 = new Employee("Jayesh","Gupta",21,15064.22);

        Employee e6 = new Employee("Ashish","Sharma",21,15064.21);

        List<Employee> list = new ArrayList<Employee>();

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);

        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,new Employee());
        System.out.println(list);
    }

}
