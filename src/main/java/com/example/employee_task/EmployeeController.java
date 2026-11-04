package com.example.employee_task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping
    public List<Employee> getEmployee() {
        return service.getEmployee();
    }
    @GetMapping("/{id}")
    public Employee getEmployeebyid(@PathVariable int id) {
        return service.getEmployeebyid(id);
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee e) {
        return service.createEmployee(e);
    }
    @PatchMapping("/{id}/{salary}")
    public Employee updateSalary(@PathVariable int id, @PathVariable int salary) {
        return service.updateSalary(id, salary);
    }
    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}