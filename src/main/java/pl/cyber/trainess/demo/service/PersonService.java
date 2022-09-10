package pl.cyber.trainess.demo.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;



@Service
@RequiredArgsConstructor
public class PersonService {

    private List<Person> personList = new ArrayList<>();

    public void createPerson(final PersonRequest request) {
        //validator

        walidujOsobe(request);

        personList.add(Person.builder()
                .imie(request.getImie())
                .nazwisko(request.getNazwisko())
                .miasto(request.getMiasto())
                .dataUrodzenia(request.getDataUrodzenia())
                .plec(request.getPlec())
                .build());
    }

    private void walidujOsobe(final PersonRequest request) {
        boolean czyIstnieje = false;
        for (Person element : personList) {
            if(element.getImie().equals(request.getImie())
                    && element.getNazwisko().equals(request.getNazwisko())
                    && element.getDataUrodzenia().equals(request.getDataUrodzenia())
            ) {
                czyIstnieje = true;
            }
        }

        if(czyIstnieje) {
            throw new RuntimeException("Taka osoba już istnieje");
        }
    }

    public PersonDTO getPerson(final PersonRequest request) {
        for (Person element : personList) {
            if(element.getImie().equals(request.getImie())
                    && element.getNazwisko().equals(request.getNazwisko())
                    && element.getDataUrodzenia().equals(request.getDataUrodzenia())) {
                return PersonDTO.builder()
                        .imie(element.getImie())
                        .nazwisko(element.getNazwisko())
                        .miasto(element.getMiasto())
                        .dataUrodzenia(element.getDataUrodzenia())
                        .plec(element.getPlec())
                        .build();
            }
        }
        return PersonDTO.builder().build();
    }

    public PersonDTO getPersonParms(final String imie, final String nazwisko) {
        for (Person element : personList) {
            if(element.getImie().equals(imie) && element.getNazwisko().equals(nazwisko)) {
                return PersonDTO.builder()
                        .imie(element.getImie())
                        .nazwisko(element.getNazwisko())
                        .miasto(element.getMiasto())
                        .dataUrodzenia(element.getDataUrodzenia())
                        .plec(element.getPlec())
                        .build();
            }
        }
        return PersonDTO.builder().build();
    }

    public void updatePerson(final PersonRequest request) {
        for (Person element : personList) {
            if(element.getImie().equals(request.getImie())
                    && element.getNazwisko().equals(request.getNazwisko())
                    && element.getDataUrodzenia().equals(request.getDataUrodzenia())) {
                element.setMiasto(request.getMiasto());
            }
        }
    }

    public List<PersonDTO> zadanie12(final KluczSortowaniaEnum klucz) {

        List<PersonDTO> resultPersonList = new ArrayList<>();

        for (Person element:personList) {
            resultPersonList.add(PersonDTO.builder()
                            .imie(element.getImie())
                            .nazwisko(element.getNazwisko())
                            .miasto(element.getMiasto())
                            .plec(element.getPlec())
                            .dataUrodzenia(element.getDataUrodzenia())
                    .build());
        }

        if(klucz.equals(KluczSortowaniaEnum.DATA)){
            resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
        }else if(klucz.equals(KluczSortowaniaEnum.IMIE)){
            resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
        }else if(klucz.equals(KluczSortowaniaEnum.NAZWISKO)){
            resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
        }else if(klucz.equals(KluczSortowaniaEnum.MIASTO)){
            resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
        }


        return resultPersonList;
    }
    public List<PersonDTO> zadanie12b(final KluczSortowaniaEnum klucz) {
        List<PersonDTO> resultPersonList = new ArrayList<>();

        for (Person element : personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(element.getImie())
                    .nazwisko(element.getNazwisko())
                    .miasto(element.getMiasto())
                    .plec(element.getPlec())
                    .dataUrodzenia(element.getDataUrodzenia())
                    .build());
        }
        switch (klucz) {
            case DATA:
                resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
                break;
            case IMIE:
                resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
                break;
            case NAZWISKO:
                resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
                break;
            case MIASTO:
                resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
                break;
        }

        return resultPersonList;
    }
    public List<PersonDTO> zadanie12c(final KluczSortowaniaEnum klucz) {
        List<PersonDTO> resultPersonList = new ArrayList<>();

        for (Person element : personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(element.getImie())
                    .nazwisko(element.getNazwisko())
                    .miasto(element.getMiasto())
                    .plec(element.getPlec())
                    .dataUrodzenia(element.getDataUrodzenia())
                    .build());
        }
        switch (klucz) {
            case DATA -> resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
            case IMIE -> resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
            case NAZWISKO -> resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
            case MIASTO -> resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
        }

        return resultPersonList;
    }

}