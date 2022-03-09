package com.webservices.restExercise.Service;

import com.webservices.restExercise.Beans.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    public static int idCount = 3;

    static {
        employees.add(new Employee("Lakshay Rawat", 21, 1));
        employees.add(new Employee("Ashish Gupta", 21, 2));
        employees.add(new Employee("Somesh Kumar Gupta", 24, 3));
    }

    public List<Employee> getEmployeesList() {
        return employees;
    }

    public Employee addEmployee(Employee emp) {
        if (emp.getId() == 0) {
            idCount++;
            emp.setId(idCount);
        }
        employees.add(emp);
        return emp;
    }

    public Employee findEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }

        return null;
    }


    public Employee deleteById(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                return emp;
            }
        }
        return null;
    }


    public Employee update(int id, String name, int age) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setAge(age);
                return employee;
            }


        }
        throw new RuntimeException("Not update Employee Details");

    }

}
