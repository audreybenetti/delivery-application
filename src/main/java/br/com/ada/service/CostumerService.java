package br.com.ada.service;


import br.com.ada.model.Costumer;
import br.com.ada.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    public Costumer save(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

    public List<Costumer> findAll(){
        return costumerRepository.findAll();
    }

    public Optional<Costumer> findById(Long id){
        return costumerRepository.findById(id);
    }


    public boolean existsById(Long id) {
        return costumerRepository.existsById(id);
    }

    public void deleteById(Long id) {
        costumerRepository.deleteById(id);
    }
}
