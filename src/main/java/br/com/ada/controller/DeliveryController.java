package br.com.ada.controller;

import br.com.ada.model.Delivery;
import br.com.ada.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request (@Valid @RequestBody Delivery delivery) throws Exception {
        return deliveryService.request(delivery);
    }
}
