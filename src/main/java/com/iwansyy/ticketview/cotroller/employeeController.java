/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.cotroller;

import com.iwansyy.ticketview.entities.Employee;
import com.iwansyy.ticketview.serviceimplement.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author iwansy
 */

@Controller
public class employeeController {
    @Autowired
    private employeeService employeeService;
    
    @GetMapping("/")
    public String viewEmployeePage(Model model){
        model.addAttribute("listEmployee", employeeService.getAllEmployee());
        return "index";
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        this.employeeService.save(employee);
        return "redirect:/";
    }
    
    @GetMapping("/showFormUpdate/{id}")
   public String showFromUpdate(@PathVariable (value = "id") String id, Model model){
       Employee employee = employeeService.getEmployeeById(id);
       model.addAttribute("employee", employee);
       return "update_employee";
   }
    
   @GetMapping("/deleteEmployee/{id}")
   public String deleteEmployee(@PathVariable (value = "id") String id){
       this.employeeService.deleteById(id);
       return "redirect:/";  
   }
   
  @GetMapping("/page/{pageNo}")
  public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model){
      return null;
  }
    
}
