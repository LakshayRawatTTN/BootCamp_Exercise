

//(1) Create an Employee Entity which contains following fields
//
//Name
//
//Id
//
//Age
//
//Location
//
//(2) Set up EmployeeRepository with Spring Data JPA
//
//(3) Perform Create Operation on Entity using Spring Data JPA
//
//(4) Perform Update Operation on Entity using Spring Data JPA
//
//(5) Perform Delete Operation on Entity using Spring Data JPA
//
//(5) Perform Read Operation on Entity using Spring Data JPA
//
//(6) Get the total count of the number of Employees
//
//(7) Implement Pagination and Sorting on the bases of Employee Age
//
//(8) Create and use finder to find Employee by Name
//
//(9) Create and use finder to find Employees starting with A character
//
//(10) Create and use finder to find Employees Between the age of 28 to 32

package com.bootcamp.springdata.employee;

import com.bootcamp.springdata.employee.entities.Employee;
import com.bootcamp.springdata.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testCreate() {
        Employee employee1 = new Employee();
        employee1.setName("Lakshay Rawat");
        employee1.setAge(21);
        employee1.setId(1);
        employee1.setLocation("Delhi");
        Employee employee2 = new Employee();
        employee2.setName("Ashish Gupta");
        employee2.setAge(21);
        employee2.setId(2);
        employee2.setLocation("Delhi");
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

    }

    @Test
    public void testUpdate() {
        Employee employee = employeeRepository.findById(1).get();
        employee.setLocation("Uttarakhand");
        employeeRepository.save(employee);
    }

    @Test
    public void testDelete() {
        employeeRepository.deleteById(2);
    }

    @Test
    public void testRead() {
        Employee employee = employeeRepository.findById(1).get();
        assertNotNull(employee);
        assertEquals("Lakshay Rawat", employee.getName());
    }

    @Test
    public void testCount() {
        System.out.println("Total employees ==>> " + employeeRepository.count());
    }

    @Test
    public void findAllPaging() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<Employee> results = employeeRepository.findAll(pageable);
        results.forEach(p -> System.out.println(p.getAge()));
    }

    @Test
    public void findAllSorting() {
        employeeRepository.findAll(Sort.by("age")).forEach(p -> System.out.println(p.getAge()));
    }

    @Test
    public void testFindByName() {
        List<Employee> employeeList = employeeRepository.findByName("iWatch");
        employeeList.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindByNameLikeA() {
        List<Employee> employees = employeeRepository.findByNameLike("A%");
        employees.forEach(e -> System.out.println(e.getId()));
    }

    @Test
    public void testFindByAgeBetween() {
        List<Employee> employees = employeeRepository.findByAgeBetween(20, 22);
        employees.forEach(e -> System.out.println(e.getId()));
    }

}
