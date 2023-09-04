package com.example.springcrudbackend.repository;

import com.example.springcrudbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
