package com.iwansyy.ticketview.serviceimplement;

import com.iwansyy.ticketview.entities.Priority;
import com.iwansyy.ticketview.repository.priorityRepository;
import com.iwansyy.ticketview.serviceinterface.priorityServiceInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author herli
 */
@Service
@Transactional
public class priorityServiceImplement implements priorityServiceInterface{
    
    @Autowired
    private priorityRepository prioRepo;
    
    
    @Override
    public void save(Priority p) {
        
        prioRepo.save(p);
    }

    @Override
    public void update(Priority p) {
        prioRepo.save(p);
    }

    @Override
    public void delete(Priority p) {
        prioRepo.delete(p);
    }

    @Override
    public void deleteById(String id) {
        prioRepo.deleteById(id);
    }

    @Override
    public Iterable<Priority> getAll() {
        return prioRepo.findAll();
    }

    @Override
    public Optional<Priority> findById(String id) {
        return prioRepo.findById(id);
    }

    @Override
    public Priority getPriorityById(String id) {
        Optional<Priority> op = prioRepo.findById(id);
        Priority priority = null;
        if(op.isPresent()){
            priority = op.get();
        }else{
            throw new RuntimeException("Employee not foun in id : "+id);
        }
        return priority;   
    }

    @Override
    public Priority savePriority(Priority priority) {
        return prioRepo.save(priority);
    }
   
    
}
