package pl.cyber.trainess.demo.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class KalkulatorService {

    public Integer getDodawanie(final Integer a, Integer b) {
        return a + b;

    }

    public Integer getOdejmowanie(final Integer a, Integer b) {
        return a - b;
    }

    public Integer getMnozenie(final Integer a, Integer b) {
        return a * b;
    }

    public Integer getDzielenie(final Integer a, Integer b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new RuntimeException("Nie dzielimy przez zero!");
        }
    }

    public Integer getReszta(final Integer a, Integer b) {
        if (b != 0) {
            return a % b;
        } else {
            throw new RuntimeException("Nie dzielimy przez zero!");
        }
    }

    public String getLiczbaPierwsza(final Integer a) {
        if (a < 2) {
            return "To liczba mniejsza od 2";
        }
        for (int i = 2; i * i < a; i++) {
            if (a % i == 0) {
                return "To nie jest liczba pierwsza";
            }
        }
        return "To jest liczba pierwsza";
    }

    public boolean getDzielnik(final Integer a, Integer b) {
        boolean wynik = true;

        if (b == 0) {
            throw new RuntimeException("Nie dzielimy przez zero");
        }else if (a % b == 0) {
            return wynik;
        }else{
            return false;

        }
    }
    //region Zadanie6
/*
Napisz program, który wygeneruje liczbę Random z przedziału od 10 - 1000.
Naszym zadaniem będzie odnalezienie wygenerowanej liczby.
W tym celu należy utworzyć zapytanie restowe, które będzie przyjmowało liczbę
i porównywało ją z wygenerowaną przez system.
Jeśli wprowadzona liczba będzie tą wygenerowaną zostanie zwrócony napis "Udało się!!"
Jeśli wprowadzona liczba będzie mniejsza od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest większa"
Jeśli wprowadzona liczba będzie większa od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest mniejsza"

Uwaga aby generowana liczba powinna być parametrem klasy aby przy każdym zapytaniu
restowym nie doszło do jej modyfikacji.
*/



}




















