package com.example.employee_task;

import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.slf4j.*;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger log=LoggerFactory.getLogger(EmployeeService.class);
    private EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }
    @Cacheable(value="employees", key="#id")
    public Employee getEmployeebyid(int id){
        log.info("Employee with id :{}", id);
        return repo.findById(id).orElseThrow(() ->new RuntimeException("NO Id found"));
    }
    @Cacheable(value="employees")
    public List<Employee> getEmployee() {
        log.info("Employee details");
        return repo.findAll();
    }
    @Transactional
    @CacheEvict(value = {"employees", "allemployees"}, allEntries = true)
    public Employee createEmployee(Employee e) {
        log.info("Added new details: {}", e.getName());
        Employee emp = repo.save(e);
        if (e.getSalary() > 100000) {
            throw new RuntimeException("Transaction failed");
        }
        return emp;

    }
    @CacheEvict(value={"employees","allemployees"}, allEntries = true)
    public Employee updateSalary(int id, int salary){
        log.info("Value updated : {}", id);
        Employee e= repo.findById(id).orElseThrow(() -> new RuntimeException("No id found"));
        e.setSalary(salary);
        return repo.save(e);
    }

    @CacheEvict(value={"employees","allemployees"}, allEntries = true)
    public Employee deleteEmployee(int id){
        log.info("delete employee : {}", id);
        Employee e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No id found"));
         repo.delete(e);
         return e;
    }
}
