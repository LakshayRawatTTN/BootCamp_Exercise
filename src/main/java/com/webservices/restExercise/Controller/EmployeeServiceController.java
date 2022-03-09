package com.webservices.restExercise.Controller;

import com.webservices.restExercise.Beans.Employee;
import com.webservices.restExercise.Exceptions.EmployeeNotFoundException;
import com.webservices.restExercise.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeServiceController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployeesList() {
        return employeeService.getEmployeesList();
    }

    @GetMapping("/employees/{id}")
    public EntityModel<Employee> getEmployeeDetails(@Valid @PathVariable int id) {
        Employee emp = employeeService.findEmployee(id);
        if (emp == null) {
            throw new EmployeeNotFoundException("Id-" + id);

        }
        EntityModel<Employee> resource = EntityModel.of(emp);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).getEmployeesList());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        Employee emp = employeeService.deleteById(id);
        if (emp == null)
            throw new EmployeeNotFoundException("Id-" + id);

    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employees/{id}/{name}/{age}")
    public void updateDetails(@PathVariable Integer id, @PathVariable String name, @PathVariable int age) {
        Employee user = employeeService.update(id, name, age);

    }


}
