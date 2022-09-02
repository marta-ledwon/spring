package pl.cyber.trainess.demo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;



@Getter
@Builder
@RequiredArgsConstructor
public class Person {
    private final String imie;
    private final String nazwisko;
    private final LocalDate dataUrodzenia;
    private final String miasto;
    private final String plec;
}
