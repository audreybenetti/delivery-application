package br.com.ada.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "Deliveries")
public class Delivery {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(to = ValidationGroups.CostumerId.class)
    @ManyToOne
    private Costumer costumer;

    @Embedded
    private Recipient recipient;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal tax;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime requestDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime deliveryDate;
}
