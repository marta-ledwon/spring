package pl.cyber.trainess.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder //adnotacja do zbudowania obiektu w oparciu o konstruktor klasy
@AllArgsConstructor
public class LiteryDTO {

    private String litera;
    private Integer ilosc;

}
