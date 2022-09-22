package br.com.ada.controller;

import br.com.ada.assemblers.OccurrenceAssembler;
import br.com.ada.model.Occurrence;
import br.com.ada.model.request.OccurrenceRequest;
import br.com.ada.model.response.DeliveryResponse;
import br.com.ada.model.response.OccurrenceResponse;
import br.com.ada.service.DeliveryService;
import br.com.ada.service.OccurrenceService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

    private DeliveryService deliveryService;
    private OccurrenceService occurrenceService;
    private OccurrenceAssembler occurrenceAssembler;

    @GetMapping
    public List<OccurrenceResponse> findOccurrences(@PathVariable Long deliveryId){
        var delivery = deliveryService.findById(deliveryId);

        return occurrenceAssembler.toResponseList(delivery.orElseThrow().getOccurrence());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceResponse register(@PathVariable Long deliveryId,
                                       @Valid @RequestBody OccurrenceRequest occurrenceRequest) throws Exception {
        var occurence = occurrenceService.register(deliveryId, occurrenceRequest.getDescription());
        return occurrenceAssembler.toResponse(occurence);
    }
}
