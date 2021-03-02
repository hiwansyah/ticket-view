/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.serviceimplement;

import com.iwansyy.ticketview.entities.Employee;
import com.iwansyy.ticketview.repository.employeeRepository;
import com.iwansyy.ticketview.serviceinterface.employeeServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iwansy
 */

@Service
@Transactional
public class employeeService implements employeeServiceInterface{

    @Autowired
    private employeeRepository repo;
    
    @Override
    public void save(Employee employee) {
        this.repo.save(employee);
    }
    
    @Override
    public void update(Employee employee) {
        repo.save(employee);
    }
    
    @Override
    public void delete(Employee employee) {
        repo.delete(employee);
    }
    
    @Override
    public void deleteById(String id) {
       this.repo.deleteById(id);
    }
    
    @Override
    public List<Employee> getAllEmployee() {        
        return (List<Employee>) repo.findAll();
    }
    
    @Override
    public Employee getEmployeeById(String id) {
        Optional<Employee> optional = repo.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else{
            throw new RuntimeException("Employee not foun in id : "+id);
        }
        return employee;
    }
    
    @Override
    public Page<Employee> findPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.repo.findAll(pageable);
    }
}