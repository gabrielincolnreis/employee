package com.example.employee.service;

import com.example.employee.domain.Employee;
import com.example.employee.exception.DataNotFoundException;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee update(Employee employee, String id) {

        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setFirstName(employee.getFirstName());
            employeeOptional.get().setLastName(employee.getLastName());
            employeeOptional.get().setEmail(employee.getEmail());
            employeeOptional.get().setNumber(employee.getNumber());
            employeeOptional.get().setDepartment(employee.getDepartment());

            return repository.save(employeeOptional.get());
        }
        throw new DataNotFoundException("Employee Id not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Employee> getById(String id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> getAll() {
        return (List<Employee>) repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
