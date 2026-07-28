package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service=service;
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return service.save(employee);
    }

}