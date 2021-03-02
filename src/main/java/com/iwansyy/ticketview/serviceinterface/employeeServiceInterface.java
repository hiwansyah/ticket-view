/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.serviceinterface;

import com.iwansyy.ticketview.entities.Employee;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author iwansy
 */

public interface employeeServiceInterface {    
    void save(Employee employee);    
    List<Employee> getAllEmployee();
    Employee getEmployeeById(String id);
    void update(Employee employee);
    void delete(Employee employee);
    void deleteById(String id);
    Page<Employee> findPagination(int pageNo, int pageSize);
}

