package com.example.springcrudbackend.controller;

import com.example.springcrudbackend.dto.Employeedto;
import com.example.springcrudbackend.entity.Employee;
import com.example.springcrudbackend.repository.EmployeeDao;
import com.example.springcrudbackend.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    private final EmployeeDao employeeDao;

    @GetMapping("/list")
    public List<Employeedto> listAllEmployee(){
        return employeeService.listAllEmployee();
    }

    @GetMapping("/{id}")
    public List<Employeedto> findEmployeeById(@PathVariable("id")int id){
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteEmployeeByid(@PathVariable("id")int id){
         employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/create")
    public Employeedto createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/update")
    public ResponseEntity<Employeedto> updateEmployee(@RequestBody Employeedto employee){

        Employee em = new Employee(employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getAddress());
        em.setId(employee.getId());
        return ResponseEntity.ok().body(employeedto(employeeDao.saveAndFlush(em)));
    }

    private  Employeedto employeedto(Employee employee){
        return new Employeedto(
                employee.getId(),employee.getFirstName(), employee.getLastName(),employee.getEmail(),employee.getAddress()
        );
    }



}
