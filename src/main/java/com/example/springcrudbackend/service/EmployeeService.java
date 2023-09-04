package com.example.springcrudbackend.service;

import com.example.springcrudbackend.dto.Employeedto;
import com.example.springcrudbackend.entity.Employee;
import com.example.springcrudbackend.repository.EmployeeDao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public List<Employeedto> listAllEmployee() {
        return employeeDao.findAll().stream().map(e -> new Employeedto(e.getId(), e.getFirstName(), e.getLastName(), e.getEmail(), e.getAddress())).collect(Collectors.toList());
    }

    public List<Employeedto> findEmployeeById(int id) {
        return employeeDao.findById(id).stream().map(this::employeedto).collect(Collectors.toList());
    }

    public void deleteEmployeeById(int id) {
        if (employeeDao.existsById(id)) {
            employeeDao.deleteById(id);
        } else {
            throw new EntityNotFoundException("not found");
        }
    }

    public Employeedto saveEmployee(Employee employee){
        Employee em = employeeDao.save(new Employee(employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getAddress()));
        return new Employeedto(em.getId(),em.getFirstName(),em.getLastName(),em.getEmail(),em.getAddress());
    }



    private  Employeedto employeedto(Employee employee){
        return new Employeedto(
                employee.getId(),employee.getFirstName(), employee.getLastName(),employee.getEmail(),employee.getAddress()
        );
    }
}
