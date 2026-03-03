package com.smartems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}