package com.smartems.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import com.smartems.entity.Employee;
import com.smartems.repository.EmployeeRepository;
import com.smartems.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Page<Employee> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return repository.findAll(pageable);
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public Employee update(Long id, Employee updated) {
        Employee employee = getById(id);
        employee.setName(updated.getName());
        employee.setEmail(updated.getEmail());
        employee.setDepartment(updated.getDepartment());
        employee.setSalary(updated.getSalary());
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}