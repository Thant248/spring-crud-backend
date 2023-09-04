package com.example.springcrudbackend;

import com.example.springcrudbackend.entity.Employee;
import com.example.springcrudbackend.repository.EmployeeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringCrudBackendApplication {
    private final EmployeeDao employeeDao;
   // @Bean
    public ApplicationRunner runner(){
        return  runner->{
            Employee employee = new Employee("John ","Doe","john@gmail.com","ygn");
            Employee employee1 = new Employee("Thomas ","Hardy","thomas@gmail.com","ygn");
            Employee employee2 = new Employee("Edison ","Dom","dom@gmail.com","ygn");
            Employee employee3 = new Employee("Arsen ","Wenger","wenger@gmail.com","ygn");
            Employee employee4 = new Employee("arteta ","mikel","arteta@gmail.com","ygn");

            // Stream.of(employee,employee1,employee2,employee3,employee4).forEach(employeeDao::save);
            Stream.of(employee,employee1,employee2,employee3,employee4).forEach(employeeDao::save);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudBackendApplication.class, args);
    }

}
