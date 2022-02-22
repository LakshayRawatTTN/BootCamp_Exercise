//Q4) WAP using java 8:
//
//    Collect all  even numbers from a list using stream
//    Given a list of objects of following class:
//
//           class Employee{
//           String fullName;
//           Long salary;
//           String city;
//           }
//
//          Get list of all unique firstNames of employees where their salary is less than 5000 and who live in delhi.
//          Note: Full name is concatenation of first name, middle name and last name with single space in between.

package Exercise4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Employee{
    String fullName;
    Long salary;
    String city;
    Employee(String fullName, Long salary, String city) {
        this.fullName = fullName;
        this.salary = salary;
        this.city = city;
    }
    public String getFullName(){
        return this.fullName;
    }
    public Long getSalary(){
        return this.salary;
    }
    public String getCity(){
        return this.city;
    }
}
public class Q4 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(l1.stream().filter(e -> e%2 == 0).collect(Collectors.toList()));
        Employee emp1 = new Employee("Lakshay Rawat", 3000L, "Delhi");
        Employee emp2 = new Employee("Ashish Gupta", 5000L, "Bihar");
        Employee emp3 = new Employee("Ashish Sharma", 2000L, "Delhi");
        Employee emp4 = new Employee("Jayesh Gupta", 300000L, "Gaziabad");
        Employee emp5 = new Employee("Vikas Chaudhary", 10000L, "Pune");
        Employee emp6 = new Employee("Jayesh Rawat", 4000L, "UK");
        List<Employee> li = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        System.out.println(li.stream()
                .filter(salary->salary.getSalary()<5000)
                .filter(city->city.getCity().equals("Delhi"))
                .map(name->name.getFullName().split(" ")[0]).distinct()
                .collect(Collectors.toList()));
    }
}
