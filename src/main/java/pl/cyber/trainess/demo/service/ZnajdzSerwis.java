package pl.cyber.trainess.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

@Slf4j
@Service
public class ZnajdzSerwis {

    private Integer losowaLiczba = 0;

    public ZnajdzSerwis() {

        Random r = new Random();
        this.losowaLiczba = r.nextInt(990) + 10;

        log.info("Wylosowana liczba to: " + this.losowaLiczba.toString());
    }
    public String znajdzLiczbe(final Integer liczba){
        if(Objects.equals(liczba, losowaLiczba)) {
            return "Udalo sie";
        }else if(liczba<losowaLiczba) {
            return "Liczba jest wieksza";
        }else{
            return "Liczba jest mniejsza";

        }
    }

}

