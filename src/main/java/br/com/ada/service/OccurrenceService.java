package br.com.ada.service;

import br.com.ada.model.Delivery;
import br.com.ada.model.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class OccurrenceService {

    private DeliveryService deliveryService;

    @Transactional
    public Occurrence register(Long deliveryId, String description) throws Exception {
        Delivery delivery = deliveryService.findById(deliveryId)
                .orElseThrow(() -> new Exception("Delivery not found."));

        return deliveryService.addOccurrence(delivery, description);
    }
}
