package br.com.ada.model;

import br.com.ada.repository.CostumerRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "Costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
}
