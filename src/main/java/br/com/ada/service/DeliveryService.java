package br.com.ada.service;

import br.com.ada.model.Delivery;
import br.com.ada.model.DeliveryStatus;
import br.com.ada.repository.CostumerRepository;
import br.com.ada.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;
    private CostumerRepository costumerRepository;

    public Delivery request (Delivery delivery) throws Exception {
        var costumer = costumerRepository.findById(delivery.getCostumer().getId())
                        .orElseThrow(() -> new Exception("Costumer not found."));

        delivery.setCostumer(costumer);
        delivery.setStatus(DeliveryStatus.PENDENTE);
        delivery.setRequestDate(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }

}
