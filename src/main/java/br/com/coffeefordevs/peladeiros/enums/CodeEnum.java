package br.com.coffeefordevs.peladeiros.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CodeEnum {
    SUCCESS(00, "SUCCESS"),
    VALUE_NOT_FOUND(44, "PEOPLE NOT FOUND");

    private Integer cod;
    private String message;

}
