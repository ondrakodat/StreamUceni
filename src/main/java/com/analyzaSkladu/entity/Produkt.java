package main.java.com.analyzaSkladu.entity;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produkt {
    private String nazev;

    private String popis;

    private Long kategorieId;

    private BigDecimal cena;

    private BigDecimal nakupniCena;

    private int minimalniSkladovaneMnozstvi;

    private String ean;

    private double hmotnost;
}
