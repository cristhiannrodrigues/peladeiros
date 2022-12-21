package br.com.coffeefordevs.peladeiros.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player")
public class PlayerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @NonNull
    private Integer idPeople;

    @NonNull
    private Integer invited = 0;

}
