package com.example.employee_management_system.controller;

import com.example.employee_management_system.entity.Department;
import com.example.employee_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }
}
