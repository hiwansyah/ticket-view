/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceimplement;

import com.iwansyy.ticketview.entities.Status;
import com.iwansyy.ticketview.repository.statusRepository;
import com.iwansyy.ticketview.serviceinterface.statusServiceInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author herli
 */

@Service
@Transactional
public class statusServiceImplement implements statusServiceInterface{

    @Autowired
    private statusRepository statusRepo;
    
    @Override
    public void save(Status status) {
        statusRepo.save(status);
    }

    @Override
    public Status getStatusById(String id) {
        
        Optional<Status> optional = statusRepo.findById(id);
        Status status = null;
        if(optional.isPresent()){
            status = optional.get();
        }else{
            throw new RuntimeException("Employee not foun in id : "+id);
        }
        
        return status;
    }

    @Override
    public void update(Status status) {
        statusRepo.save(status);
    }

    @Override
    public void delete(Status status) {
        statusRepo.delete(status);
    }

    @Override
    public void deleteById(String id) {
        statusRepo.deleteById(id);
    }

    @Override
    public Iterable<Status> getAll() {
        return statusRepo.findAll();
    }

    @Override
    public Optional<Status> findById(String id) {
        return statusRepo.findById(id);
    }
    
}
