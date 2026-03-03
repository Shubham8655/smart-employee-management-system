package com.smartems.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartems.entity.Employee;
import com.smartems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(service.create(employee));
    }

    @GetMapping
    public Page<Employee> getAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,
                           @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }
}