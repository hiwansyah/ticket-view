/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceimplement;

import com.iwansyy.ticketview.entities.Services;
import com.iwansyy.ticketview.repository.servicesRepository;
import com.iwansyy.ticketview.serviceinterface.servicesServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iwansy
 */


@Service
@Transactional
public class servicesService implements servicesServiceInterface{

    @Autowired
    private servicesRepository repo;
    
    @Override
    public void save(Services services) {
        this.repo.save(services);
    }

    @Override
    public List<Services> getAllServices() {
        return (List<Services>) repo.findAll();
    }

    @Override
    public Services getServicesById(String id) {
        Optional<Services> optional = repo.findById(id);
        Services services = null;
        if (optional.isPresent()) {
            services = optional.get();
        } else {
            throw new RuntimeException("Services not found in id : "+id);
        }
        return services;
    }

    @Override
    public void update(Services services) {
        repo.save(services);
    }

    @Override
    public void delete(Services services) {
        repo.delete(services);
    }

    @Override
    public void deleteById(String id) {
        this.repo.deleteById(id);
    }
    
}
