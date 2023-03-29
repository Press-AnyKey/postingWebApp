package com.example.webapptest.repository;

import com.example.webapptest.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    Department findByDepartment(String department);
}
