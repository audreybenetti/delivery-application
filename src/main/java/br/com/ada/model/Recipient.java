package br.com.ada.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Recipient {

    @Column(name = "recipient_name")
    private String name;

    @Column(name = "recipient_street")
    private String street;

    @Column(name = "recipient_district")
    private String district;

    @Column(name = "recipient_city")
    private String city;

    @Column(name = "recipient_state")
    private String state;

    @Column(name = "recipient_zip")
    private Long zipCode;

    @Column(name = "recipient_complement")
    private String complement;

}
