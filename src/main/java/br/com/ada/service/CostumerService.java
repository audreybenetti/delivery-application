package br.com.ada.service;


import br.com.ada.model.Costumer;
import br.com.ada.repository.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CostumerService {

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
