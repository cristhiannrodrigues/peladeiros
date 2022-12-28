package br.com.coffeefordevs.peladeiros.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Integer id;
    private Date date;
    private String name;
    private String local;

}
