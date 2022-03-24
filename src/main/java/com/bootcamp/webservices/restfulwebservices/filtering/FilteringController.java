package com.bootcamp.webservices.restfulwebservices.filtering;

import com.bootcamp.webservices.restfulwebservices.beans.Employee;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {



    @GetMapping("/static-filtering")
    public Employee addEmployee(){
        return new Employee(1,"Lakshay","1234Pass");
    }


    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue addEmployees(){
        Employee emp = new Employee(1,"Lakshay","1234Pass");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(emp);
        mapping.setFilters(filters);
        return mapping;
    }


}
