package pl.cyber.trainess.demo.service;


import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.IntegerRequest;
import pl.cyber.trainess.demo.dto.RownanieKwRequest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


@Service
public class KalkulatorService {
//metoda dodawania

    public Integer getDodawanie(final Integer a, final Integer b) {
        return a + b;
    }

    public Integer getOdejmowanie(final Integer liczbaA, final Integer liczbaB) {
        return liczbaA - liczbaB;
    }

    public Integer getMnozenie(final Integer liczbaA, final Integer liczbaB) {
        return liczbaA * liczbaB;
    }

    public Integer getDzielenie(final Integer liczbaA, final Integer liczbaB) {

//    if(liczbaB!=0) {
//      return liczbaA/liczbaB;
//    } else {
//      throw new RuntimeException("Nie dziel przez 0!!!");
//    }

        if (liczbaB == 0) {
            throw new RuntimeException("Nie dziel przez 0!!!");
        }

        return liczbaA / liczbaB;
    }

    public Integer getReszta(final Integer liczbaA, final Integer liczbaB) {
        if (liczbaB == 0) {
            throw new RuntimeException("Nie dziel przez 0!!!");
        }

        return liczbaA % liczbaB;
    }

    public String czyLiczbaPierwsza(final Integer a) {

        if (a < 2) {
            return "To nie jest liczba pierwsza!";
        }

//     for(int i=2; i<=a/2; i++) {
        for (int i = 2; i * i < a; i++) {
            System.out.println(i * i);
            if (a % i == 0) {
                return "To nie jest liczba pierwsza!";
            }
        }
        return "To jest liczba pierwsza!";
    }

    public boolean getCzyJestDzielnikiem(final Integer a, final Integer b) {
        if (b == 0) {
            throw new RuntimeException("Nie wolno dzielić przez 0!!");
        }

//    return a%b == 0;

        return a % b == 0;
    }

    public String rownanieKwadratowe(final Integer a, final Integer b, final Integer c) {

        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        if (a == 0) {
            return "To nie jest równanie kwadratowe";
        }

        delta = Double.valueOf(b * b - 4 * a * c);

        if (delta < 0) {
            return "Brak pierwiastków";
        } else {
            if (delta == 0) {
                x1 = Double.valueOf(-b / (2 * a));
                return "Jeden pierwiastek. Wynik: " + x1;
            } else {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                return "Dwa pierwiasteki. Wynik x1: " + x1 + " x2: " + x2;
            }
        }
    }

    public String rownanieKwadratowe(final RownanieKwRequest request) {

        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        Double a = request.getA();
        Double b = request.getB();
        Double c = request.getC();

        delta = b * b - 4 * a * c;

        if (delta == 0) {
            x1 = -b / (2 * a);
            return "Jeden pierwiastek. Wynik: " + x1;
        } else if (delta < 0) {
            return "Brak pierwiastków.";
        } else {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            return "Dwa pierwiastki. Wynik x1: " + x1 + " x2: " + x2;
        }
    }

    public String rownanieKwadratowe2miejsca(final RownanieKwRequest request) {
        Locale englishLocale = Locale.ENGLISH;
        Locale polishLocale = Locale.forLanguageTag("pl-PL");

        Locale.setDefault(polishLocale);

        DecimalFormat df = new DecimalFormat("#,##0.00");
    /*
    1.10
    #,###.00 >  1,10
    1101.10
    #,###.00 >  1 101,10
    1.10
    #,###.0# >  1,10
    1.1
    #,###.0# >  1,1
    1.1131421125
    #,###.0# >  1,11
    1.1161421125
    #,###.0# >  1,12
    1.1161421125
    #,###.0## >  1,116
    1101.10
    #.# > 1101,1
    1101.1
    #.0000 > 1101,1000
     */

        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        Double a = request.getA();
        Double b = request.getB();
        Double c = request.getC();

        delta = b * b - 4 * a * c;

        if (delta == 0) {
            x1 = -b / (2 * a);
            return "Jeden pierwiastek. Wynik: " + df.format(x1);
        } else if (delta < 0) {
            return "Brak pierwiastków.";
        } else {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            return "Dwa pierwiastki. Wynik x1: " + df.format(x1) + " x2: " + df.format(x2);
        }
    }

//    public String zadanie10a() {
//        Integer y = 0;
//
//        String result = "Program oblicza wartosc funkcji y = 3x dla x zmieniajacego sie od 0 do 10. \n";
//
//        for(int x = 0; x<=10; x++){
//            y = 3*x;
//            result += "x =  " + x + "\t " + "y =  " + y + "\n";
//        }
//
//        return result;

    public String zadanie10a() {
        Integer y = 0;

        StringBuilder result = new StringBuilder("Program oblicza wartosc funkcji y = 3x dla x zmieniajacego sie od 0 do 10. \n");

        for (int x = 0; x <= 10; x++) {
            y = 3 * x;
            result.append("x= ").append(x).append("\t ").append("y =  ").append(y).append("\n");
        }
        return result.toString();
    }


    public String zadanie10b() {
        Integer y = 0;
        Integer x = 0;

        String result = "Program oblicza wartosc funkcji y = 3x dla x zmieniajacego sie od 0 do 10." + "Za pomoca petli do... while \n";

        do {
            y = 3 * x;
            result += "x = " + x + "\t" + "y = " + y + "\n";
            x++;

        } while (x <= 10);
        return result;
    }

    public String zadanie10c() {
        Integer y = 0;
        Integer x = 0;


        String result = "Program oblicza wartosci funckji y=3x dla x zmieniajacego sie od 0 do 10. \n" + "Przy pomocy petli while \n";

        while (x <= 10) {
            y = 3 * x;
            result += "x = " + x + "\t" + "y = " + y + "\n";
            x++;
        }
        return result;
    }

    public String zadanie11a() {

        Integer n = 10;

        String result = "Program wyswietla tabliczke mnozenia.\n\n";

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                result += (i * j) + "\t";
            }
            result += "\n";
        }
        return result;
    }

    public String zadanie11aa() {

        Integer w = 20;
        Integer k = 15;

        String result = "Program wyswietla tabliczke mnozenia.\n\n";

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= k; j++) {
                result += (i * j) + "\t";
            }
            result += "\n";
        }
        return result;

    }

    public String zadanie11b() {

        Integer k = 10;
        Integer w = 20;
        Integer wiersz = 1;
        Integer kolumna = 1;


        String result = "Program wyswietla tabliczke mnozenia do... while. \n\n";

        do {
            kolumna = 1;
            do {
                result += wiersz * kolumna;
                result += "\t";
                kolumna++;

            } while (kolumna <= k);
            result += "\n";
            wiersz++;
        } while (wiersz <= w);

        return result;
    }

    public String zadanie11c() {

        Integer wiersz = 1;
        Integer kolumna = 1;
        Integer k = 10;
        Integer w = 20;

        String result = "Program wyswietla macierz z petli while.\n\n";

        while (wiersz <= w) {
            kolumna = 1;
            while (kolumna <= k) {
                result += wiersz * kolumna + "\t";
                kolumna++;
            }
            result += "\n";
            wiersz++;
        }
        return result;
    }

    public String zadanie10d(final IntegerRequest request) {

        Integer y = 0;
        StringBuilder result = new StringBuilder("Program oblicza wartosc funkcji y=3x " +
                "dla x zmienaijacego sie od 0 do wartosci podanej przez uzytkownika");
        for (int x = 0; x <= request.getParametrA(); x++) {
            y = 3 * x;

            result.append("x = ").append(x).append("\t").append("y = ").append(y).append("\n");
        }

        return result.toString();

    }

    public String zadanie10e(final IntegerRequest request) {

        Integer y = 0;
        Integer x = 0;

        StringBuilder result = new StringBuilder("Program oblicza wartosc funkcji ");
        do {
            y = 3 * x;
            result.append("x = ").append(x).append("\t").append("y = ").append(y).append("\n");
            x++;

        } while (x <= request.getParametrA());

        return result.toString();
    }

    public String zadanie10f(final IntegerRequest request) {
        Integer x = 0;

        StringBuilder result = new StringBuilder("Program oblicza wartosc funkcji y=3*x");

        while (x <= request.getParametrA()) {
            result.append("x = ").append(x).append("\t").append("y = ").append(3 * x).append("\n");
            x++;
        }
        return result.toString();
    }

    public String zadanie12for(final IntegerRequest request) {

        Random random = new Random();
        Integer iloscLosowan = request.getParametrA();
        List<Integer> listaLiczb = new ArrayList<>();

        Integer min = 100;
        Integer max = 0;
        Integer suma = 0;
        Double srednia = 0.0;

        for (int i = 0; i < iloscLosowan; i++) {
            listaLiczb.add(random.nextInt(100));
        }
        //region
//        for (int i = 0; i < listaLiczb.size(); i++) {
//            Integer element = listaLiczb.get(i);
//
//            suma += element;
//
//            if (element < min) {
//                min = element;
//            }
//            if (element > max) {
//                max = element;
//            }
//        }
        //endregion

        for (Integer element:listaLiczb) {
            suma += element;

            if(element<min){
                min = element;
            }if(element>max){
                max = element;
            }
        }
        srednia = (double) suma / listaLiczb.size();
        return "dla listy: " + listaLiczb + " min: " + min + " max: "
                + max + ", natomiast srednia liczby: " + srednia;
    }

}





















