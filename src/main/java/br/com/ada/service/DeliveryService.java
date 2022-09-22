package br.com.ada.service;

import br.com.ada.model.Delivery;
import br.com.ada.model.DeliveryStatus;
import br.com.ada.model.Occurrence;
import br.com.ada.model.response.DeliveryResponse;
import br.com.ada.repository.CostumerRepository;
import br.com.ada.repository.DeliveryRepository;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Delivery> findById(Long id) {
        return deliveryRepository.findById(id);
    }

    public Occurrence addOccurrence(Delivery delivery, String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setRegistrationDate(LocalDateTime.now());
        occurrence.setDelivery(delivery);

        delivery.getOccurrence().add(occurrence);

        return occurrence;
    }
}
