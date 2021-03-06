/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.serviceinterface;

import com.iwansyy.ticketview.entities.Status;
import java.util.Optional;

/**
 *
 * @author iwansy
 */

public interface statusServiceInterface {
    void save(Status status);
    
    Status getStatusById(String id);
    void update(Status status);
    void delete(Status status);
    void deleteById(String id);
    Iterable <Status> getAll();
    Optional <Status> findById(String id);
}
