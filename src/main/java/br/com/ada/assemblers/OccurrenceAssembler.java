package br.com.ada.assemblers;

import br.com.ada.model.Occurrence;
import br.com.ada.model.response.OccurrenceResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {

    private ModelMapper mapper;

    public OccurrenceResponse toResponse(Occurrence occurrence){
        return mapper.map(occurrence, OccurrenceResponse.class);
    }

    public List<OccurrenceResponse> toResponseList(List<Occurrence> occurrences){
        return occurrences.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
