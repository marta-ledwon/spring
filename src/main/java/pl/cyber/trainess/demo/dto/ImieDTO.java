package pl.cyber.trainess.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter // ta adnotacja ma za zadanie dodanie do klasy metod getter
//dla jej parametrow

public class ImieDTO {
    private final String imie;

    @Builder // łatwiejsze przygotowanie tej klasy do uzycia bez wypelniania konstruktowra
    @ConstructorProperties({"imie"}) // pomaga w budowaniu pliku wynikowego JSON
    public ImieDTO(final String imie) {
        this.imie = imie;
    }
}
