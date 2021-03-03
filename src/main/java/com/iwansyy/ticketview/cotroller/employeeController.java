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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author iwansy
 */
@Controller
public class employeeController {

    @Autowired
    private employeeService employeeService;

    @GetMapping("/employee")
    public String viewEmployeePage(Model model) {
        model.addAttribute("listemployee", employeeService.getAllEmployee());
        return "index";
    }

//    @RequestMapping(value = "/showNewEmployeeForm", method = RequestMethod.POST)
//    public String showNewEmployeeForm(
//            @PathVariable())
////            @ModelAttribute("new_employee") Employee employee,
////            @RequestParam(value = "employeeId", required = false) String employeeId,
////            @RequestParam(value = "employeeName", required = false) String employeeName,
////            @RequestParam(value = "password", required = false) String password
//    ) {
//            Employee employeeOne = employeeService.findOne(employeeId);
//            
//        
//        
////            Employee employees = new Employee(employeeId, employeeName, password);
//            
//            
//        return "new_employee";
//    }
    @GetMapping("/shownewemployeeform")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        System.out.println(model.addAttribute("employee", employee));
        model.addAttribute("employee", employee);

        return "new_employee";
    }

    @PostMapping("/saveemployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        this.employeeService.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/showformupdate/{id}", method = RequestMethod.POST)
    public String showUpdateForm(
            @RequestParam(value = "employeeId", required = false) String employeeId,
            @RequestParam(value = "employeeName", required = false) String employeeName,
            @RequestParam(value = "password", required = false) String password
    ) {
         Employee employee = new Employee(employeeId, employeeName, password);
//         employee.setEmployeeId(employeeId);
//         employee.setEmployeeName(employeeName);
//         employee.setPassword(password);
         
         employeeService.save(employee);
         return "redirect:/employee";
    }

    
    @GetMapping("/showformupdate/{id}")
    public String showFromUpdate(@PathVariable(value = "id") String id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }
//
//    @PostMapping("/updateemployee/{id}")
//    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
//
//        this.employeeService.save(employee);
//        return "redirect:/employee";
//    }

//    @GetMapping("/showformupdate/{id}")
//    public String showFromUpdate(@PathVariable(value = "id") String id, Model model) {
//        Employee employee = employeeService.getEmployeeById(id);
//        model.addAttribute("employee", employee);
//        return "update_employee";
//    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id) {
        this.employeeService.deleteById(id);
        return "redirect:/employee";
    }

    @GetMapping("/page/{pageno}")
    public String findPaginated(@PathVariable(value = "pageno") int pageNo, Model model) {
        return null;
    }

}
