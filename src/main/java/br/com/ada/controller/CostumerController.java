package br.com.ada.controller;

import br.com.ada.model.Costumer;
import br.com.ada.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/costumers")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Costumer create(@Valid @RequestBody Costumer costumer){
        return costumerService.save(costumer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Costumer> update(@PathVariable Long id,
                                          @Valid @RequestBody Costumer costumer){
        if (costumerService.existsById(id)) {
            costumer.setId(id);
            costumer = costumerService.save(costumer);
            return ResponseEntity.ok(costumer);
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Costumer> find(){
        return costumerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costumer> findById(@PathVariable Long id){
        return costumerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(costumerService.existsById(id)){
            costumerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.notFound().build();
    }
}
