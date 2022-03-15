package com.bootcamp.exercise.employee.repos;

import com.bootcamp.exercise.employee.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {


    @Query("select firstName,lastName from Employee where Salary > (select AVG(Salary) from Employee)")
    List<Object[]> findFirstnameLastname(Sort sort);

    @Modifying
    @Query("update Employee set Salary=:Salary where Salary < (select AVG(Salary) from Employee)")
    void updateSalary(@Param("Salary") int salary);

    @Modifying
    @Query("delete from Employee where Salary = (select MIN(Salary) from Employee)")
    void deleteMinSalary();

    //native query 1
    //Display the id, first name, age of all employees where last name ends with "singh"
    @Query(value = "select empid,empFirstname,empAge from employee where empLastname =:lastName", nativeQuery = true)
    List<Object[]> findAllEmployeeByLastNameNQ(@Param("lastName") String lastName);

    //native query 2
    //Delete all employees with age greater than 45(Should be passed as a parameter)
    @Modifying
    @Query(value = "delete from employee where empAge >:age", nativeQuery = true)
    void deleteAgeGreaterThanNQ(@Param("age") int age);

}
