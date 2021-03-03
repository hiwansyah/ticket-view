/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.cotroller;

import com.iwansyy.ticketview.entities.Status;
import com.iwansyy.ticketview.serviceimplement.statusServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author herli
 */
@Controller
public class statusController {
    
    @Autowired
    private statusServiceImplement statServImp;
    
    @GetMapping("/showStatus")
    public String showStatusList(Model m){
    
        m.addAttribute("listStatus", statServImp.getAll());
        
        return "status";
    }
    
    @GetMapping("/showAddStatus")
    public String showFormAddStatus(Model m){
        
        Status status  = new Status();
        m.addAttribute("status", status);
        
        return "statusAdd";
    }
    
    @PostMapping("/saveStatus")
    public String saveStatus(@ModelAttribute ("status") Status status){
        statServImp.save(status);
        return "redirect:showStatus";
    }
    
    @GetMapping("/showFormUpdateStatus/{id}")
    public String showFormUpdateStatus(@PathVariable (value="id") String id, Model model){
        Status status = statServImp.getStatusById(id);
        model.addAttribute("status", status);
        
        return "statusUpdate";
    }
    
    @GetMapping("/deleteStatus/{id}")
    public String deleteStatus(@PathVariable (value ="id") String id){
        
        statServImp.deleteById(id);
        return "redirect:/showStatus";
    }
   
}
