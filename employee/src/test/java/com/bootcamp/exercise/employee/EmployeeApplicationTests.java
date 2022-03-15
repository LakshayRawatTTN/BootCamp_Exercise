package com.bootcamp.exercise.employee;

import com.bootcamp.exercise.employee.entities.Employee;
import com.bootcamp.exercise.employee.entities.Salary;
import com.bootcamp.exercise.employee.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class EmployeeApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }


    @Test
    public void testCreateEmployee() {

        Employee employee1 = new Employee();
        employee1.setFirstName("Lakshay");
        employee1.setLastName("Rawat");
        employee1.setAge(21);
        employee1.setSalary(15555);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Ritik");
        employee2.setLastName("singh");
        employee2.setAge(22);
        employee2.setSalary(15005);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Ashish");
        employee3.setLastName("Gupta");
        employee3.setAge(21);
        employee3.setSalary(15000);
        employeeRepository.save(employee3);


        Employee employee4 = new Employee();
        employee4.setFirstName("Somesh Kumar");
        employee4.setLastName("Gupta");
        employee4.setAge(25);
        employee4.setSalary(5000);
        employeeRepository.save(employee4);
    }

    @Test
    public void testJpqlToGetFirstAndLastName() {

        List<Object[]> objects = employeeRepository.findFirstnameLastname(Sort.by("age").and(Sort.by("Salary").descending()));
        for (Object[] employee : objects) {
            System.out.print("First Name: " + employee[0]);
            System.out.println(" Last Name: " + employee[1]);
        }

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteEmployeeWithMinSalary() {
        employeeRepository.deleteMinSalary();
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateSalary() {
        employeeRepository.updateSalary(20000);
    }

    @Test
    public void testSinghNQ() {
        List<Object[]> employees = employeeRepository.findAllEmployeeByLastNameNQ("singh");
        for (Object[] employee : employees) {
            System.out.println(employee[0] + " " + employee[1] + " " + employee[2]);
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteNQ() {
        employeeRepository.deleteAgeGreaterThanNQ(45);
    }

    @Test
    public void testEmbedded() {
        Salary salary = new Salary();
        salary.setBasicsalary(15000);
        salary.setBonussalary(15000);
        salary.setSpecialallowancesalary(15000);
        salary.setTaxamount(2000);
        Employee employee = new Employee();
        employee.setFirstName("Ashita");
        employee.setLastName("Gupta");
        employee.setAge(21);
        employee.setSalary(15000);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }
}
