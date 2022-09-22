package br.com.ada.controller;

import br.com.ada.model.Delivery;
import br.com.ada.model.response.DeliveryResponse;
import br.com.ada.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryService deliveryService;
    private ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request (@Valid @RequestBody Delivery delivery) throws Exception {
        return deliveryService.request(delivery);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponse> find(@PathVariable Long id){
        return deliveryService.findById(id)
                .map(delivery -> {
                    var response = mapper.map(delivery, DeliveryResponse.class);
                    return ResponseEntity.ok(response);
                }).orElse(ResponseEntity.notFound().build());
    }
}
