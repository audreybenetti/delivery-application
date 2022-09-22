package br.com.ada.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceRequest {

    @NotBlank
    private String description;
}
