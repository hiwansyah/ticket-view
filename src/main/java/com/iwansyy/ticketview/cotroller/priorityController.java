/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.cotroller;

import com.iwansyy.ticketview.entities.Priority;
import com.iwansyy.ticketview.serviceimplement.priorityServiceImplement;
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
 * @author herli
 */

@Controller
public class priorityController {
    
    @Autowired
    private priorityServiceImplement prioServImp;
    
    //test datatable
    @RequestMapping(value = "/testDataTable", method = RequestMethod.GET)
    public String getPriorityListTestDataTable(Model model){
        model.addAttribute("listPriority", prioServImp.getAll());
        
        return "testDataTableView";
    }
    
    //menampilkan daftar priority
    @GetMapping("/showPriority")
    public String showPriorityList(Model m){
    
        m.addAttribute("listPriority",prioServImp.getAll());
        return "priority";
    }
    
    //menampilkan halaman tambah priority
    @GetMapping("/showFormAddPriority")
    public String showFormAddPriority(Model m){
    
        Priority priority = new Priority();
        m.addAttribute("priority",priority);
        return "priorityAdd";
    }
    
    @PostMapping("/savePriority")
    public String savaPriority(@ModelAttribute("priority") Priority priority){
    
        prioServImp.save(priority);
        return "redirect:/showPriority";
    }
    
    // menampilkan form update
    @GetMapping("/showFormUpdatePriority/{id}")
    public String showFormUpdatePriority(@PathVariable (value ="id") String id, Model model){
    
        Priority priority = prioServImp.getPriorityById(id);
        model.addAttribute("priority",priority);
        return "priorityUpdate";
    }
    
    //menyimpan priority update
    @RequestMapping(value = "/saveUpdatePriority/{id}", method = RequestMethod.POST)
    public String savaUpdatePriority(
            
//            @RequestParam String id,
            @RequestParam(value="priorityName") String name,  
            @RequestParam(value="responseTime") Integer RespTime, 
            @RequestParam(value="resolveTime") Integer ResolvTime
    ){
            
        Priority priority = new Priority(name, ResolvTime, ResolvTime);
        
//        priority.setPriorityName(name);
//        priority.setResponseTime(RespTime);
//        priority.setResolveTime(ResolvTime);
        prioServImp.savePriority(priority);

        return "redirect:showPriority";
    }
    
    @GetMapping("/deletePriority/{id}")
    public String deletePriority(@PathVariable (value = "id") String id){
    
        prioServImp.deleteById(id);
        return "redirect:/showPriority";
    }
    
    
}
