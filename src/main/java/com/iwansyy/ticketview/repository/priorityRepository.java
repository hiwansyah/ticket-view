/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.repository;

import com.iwansyy.ticketview.entities.Priority;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iwansy
 */

public interface priorityRepository extends CrudRepository<Priority, String>{
    
}
