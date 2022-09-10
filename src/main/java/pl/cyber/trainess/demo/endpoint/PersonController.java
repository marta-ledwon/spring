package pl.cyber.trainess.demo.endpoint;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.cyber.trainess.demo.dto.KluczSortowaniaEnum;
import pl.cyber.trainess.demo.dto.PersonDTO;
import pl.cyber.trainess.demo.dto.PersonRequest;
import pl.cyber.trainess.demo.service.PersonService;

import java.util.List;


@Slf4j //odpowiada za logi w ramach serwera
@RestController //Adnotacja mówi serwera Spring, że w tym miejscu będą funkcjonalności REST API
@RequiredArgsConstructor
@RequestMapping("/v1/persons")
public class PersonController {

    private final PersonService service;


    @GetMapping("/person")
    public PersonDTO getPerson(@RequestBody final PersonRequest request) {
        return service.getPerson(request);
    }

    @GetMapping("/person/params")
    public PersonDTO getPersonParams(
            @RequestParam final String imie,
            @RequestParam final String nazwisko
    ) {
        return service.getPersonParms(imie, nazwisko);
    }

    @PutMapping("/create")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPerson(@RequestBody final PersonRequest request){
        log.info("Dokonuje utworzenia Osoby");
        service.createPerson(request);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@RequestBody final PersonRequest request){
        log.info("Dokonuje aktualizacji Osoby");
        service.updatePerson(request);
    }


  /*
  User PersonDTO        <->  Server Person  <->  DB PersonEntity
       PersonRequest
   */


//  Zadanie Utworzyć 2 obiekty:
//  1. PersonDTO, który będzie przekazywany dla użytkownika
//  2. Person jako obiekt wewnętrzny aplikacji
//  GET(@GetMapping), PUT(@PutMapping), POST(@PostMapping)
//  PersonRequest
//  Utworzyć metody REST do Tworzenia użytkownika, zmiany jest danych oraz jego pobierania.

//  Imie, nazwisko, date urodzenia, miasto zamieszkania oraz Płeć.

    /*
      Wykonaj createPerson z PersonController aby utworzyć 6 różnych osób (przy użyciu Postman), następnie
      napisz program, który z kolekcji typu List posiadającej  6 różnych osób(w oparciu o poprzednie zadanie)
      posortuje ich względem wskazanego klucza (np. miasta, datyUrodzenia, nazwiska lub imienia).
      Po czym zostanie zwrócona posortowana lista do użytkownika.
    */
    @GetMapping("/zadanie12")
    public List<PersonDTO> zadanie12(
            @RequestParam("klucz") final KluczSortowaniaEnum klucz)
    {
        return service.zadanie12(klucz);
    }


}