package Exercise3;


//4) Create class Employee with attributes name,age,designation and use instances of these class as keys in a Map and their salary as value


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Employees
{
    private String name;
    private int salary ;
    private String designation;


    public Employees(String name, int salary, String designation) {
        super();
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getSalary() {
        return salary;
    }


    public void setSalary(int age) {
        this.salary = salary;
    }


    public String getDesignation() {
        return designation;
    }


    public void setDesignation() {
        this.designation = designation;
    }


    public String toString()
    {

        return ("Employee { "+" Name: "+name+", Salary : "+salary+", Designation :"+designation+" }");
    }

}

public class Q4 {
    public static void main(String[] as)
    {

       

        Map<Employees,Integer> hashMap=new HashMap<Employees,Integer>();

        Employees emp1=new Employees("Tome", 18000,"JVM");

        Employees emp2=new Employees("Jone", 17000,"ASM");

        Employees emp3=new Employees("Yash", 20000, "QA");

        Employees emp4=new Employees("Jon", 21000,"CSV");

        hashMap.put(emp1,emp1.getSalary());
        hashMap.put(emp2,emp1.getSalary());
        hashMap.put(emp3,emp3.getSalary());
        hashMap.put(emp4,emp4.getSalary());

        Set<Map.Entry<Employees, Integer>> entries =  hashMap.entrySet();


        for(Map.Entry<Employees, Integer> emp:entries)
        {
            System.out.print(emp.getKey());
            System.out.print(" "+emp.getValue());

            System.out.println();


        }

    }

}
