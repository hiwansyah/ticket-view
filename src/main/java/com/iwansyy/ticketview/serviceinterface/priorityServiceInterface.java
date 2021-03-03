/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceinterface;

import com.iwansyy.ticketview.entities.Priority;
import java.util.Optional;

/**
 *
 * @author herli
 */
public interface priorityServiceInterface {
    void save(Priority p);
    void update(Priority p);
    void delete (Priority p);
    void deleteById(String id);
    Iterable <Priority> getAll();
    Optional <Priority> findById(String id);
    
    Priority getPriorityById(String id);
    
    Priority savePriority(Priority priority);
}
