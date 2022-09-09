package pl.cyber.trainess.demo.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cyber.trainess.demo.dto.ImieDTO;
import pl.cyber.trainess.demo.service.PersonService;


@Slf4j //odpowiada za logi w ramach serwera
@RestController //Adnotacja mówi serwera Spring, że w tym miejscu będą funkcjonalności REST API
@RequiredArgsConstructor
@RequestMapping("/v1/first")
public class PierwszyController {

    private final PersonService service;

    //HTTP metoda GET - metoda służy do pobierania informacji z serwera
    @GetMapping("/{imie}")
    public ImieDTO getImie(@PathVariable final String imie) {
        return ImieDTO.builder()
                .imie(imie)
                .build();
    }

}