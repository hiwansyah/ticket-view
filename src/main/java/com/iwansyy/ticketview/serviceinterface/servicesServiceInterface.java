/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceinterface;

import com.iwansyy.ticketview.entities.Services;
import java.util.List;

/**
 *
 * @author iwansy
 */

public interface servicesServiceInterface {
    void save(Services services);    
    List<Services> getAllServices();
    Services getServicesById(String id);
    void update(Services employee);
    void delete(Services employee);
    void deleteById(String id);
}
