package br.com.ada.service;

import br.com.ada.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

}
