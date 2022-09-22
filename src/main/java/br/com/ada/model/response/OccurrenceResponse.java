package br.com.ada.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OccurrenceResponse {

    private Long id;
    private String description;
    private LocalDateTime registrationDate;

}
