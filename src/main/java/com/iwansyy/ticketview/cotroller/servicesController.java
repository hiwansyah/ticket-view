/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.cotroller;

import com.iwansyy.ticketview.entities.Services;
import com.iwansyy.ticketview.serviceimplement.servicesService;
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
public class servicesController {
    @Autowired
    private servicesService servicesService;
    
    @GetMapping("/services")
    public String viewServicesPage(Model model){
        model.addAttribute("listservices", servicesService.getAllServices());
        return "index1";
    } 
    
    @GetMapping("/shownewservicesform")
    public String showNewServicesForm(Model model){
        Services services = new Services();
        model.addAttribute("services", services);
        return "new_services";
    }
    
     @PostMapping("/saveservices")
    public String saveServices(@ModelAttribute("services") Services services) {
        this.servicesService.save(services);
        return "redirect:/services";
    }

    @GetMapping("/showformupdateservices/{id}")
    public String showFromUpdateServices(@PathVariable(value = "id") String id, Model model) {
        Services services = servicesService.getServicesById(id);
        model.addAttribute("services", services);
        return "update_services";
    }

    @GetMapping("/deleteservices/{id}")
    public String deleteServices(@PathVariable(value = "id") String id) {
        this.servicesService.deleteById(id);
        return "redirect:/services";
    }
    
}
