package com.example.employee.repository;

import com.example.employee.domain.Employee;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableScan
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {
    Employee save(Employee employee);

    Optional<Employee> findById(String id);

    void deleteById(String id);

    Object findAll();
}
