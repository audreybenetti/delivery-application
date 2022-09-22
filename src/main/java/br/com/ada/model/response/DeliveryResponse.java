package br.com.ada.model.response;

import br.com.ada.model.DeliveryStatus;
import br.com.ada.model.Recipient;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class DeliveryResponse {
    private Long id;
    private String costumerName;
    private Recipient recipientResponse;
    private BigDecimal tax;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime requestDate;
    private LocalDateTime deliveyDate;
}
