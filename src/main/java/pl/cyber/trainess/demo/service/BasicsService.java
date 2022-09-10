package pl.cyber.trainess.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.IntegerListRequest;
import pl.cyber.trainess.demo.dto.LiteryDTO;
import pl.cyber.trainess.demo.dto.OneStringRequest;
import pl.cyber.trainess.demo.dto.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BasicsService {
    private static String SPACJA = " ";
    public String getSklejenie(final StringRequest request) {
//    return request.getStringPierwszy()+request.getStringDrugi();

        //Alternatywa przy użyciu zewnętrznej biblioteki
        var string = new StringBuilder();
        return string
                .append(request.getStringPierwszy())
                .append(SPACJA)
                .append(request.getStringDrugi())
                .toString();
    }

    //region Zadanie w oparciu o listy
    public List<String> getWystapieniaLiterWZadaniu(final OneStringRequest request) {
        List<LiteryDTO> wystapienia = new ArrayList<>();
        Set<String> litery = new HashSet<>();
        List<String> wynik = new ArrayList<>();

        String zdanie = request.getValue();

        for(int i = 0; i < zdanie.length(); i++) {
            String litera = String.valueOf(zdanie.charAt(i));

            if(litera.matches("[a-zA-Z]+")) {
                if(wystapienia.size() == 0) {
                    litery.add(litera.toLowerCase());
//          wystapienia.add(LiteryDTO.builder()
//                  .litera(litera.toLowerCase())
//                  .ilosc(1)
//              .build());
                    wystapienia.add(new LiteryDTO(litera.toLowerCase(), 1));
                } else {
                    if (litery.contains(litera.toLowerCase())) {
                        for (LiteryDTO element :
                                wystapienia) {
                            if (element.getLitera().equals(litera.toLowerCase())) {
                                element.setIlosc(element.getIlosc() + 1);
                            }
                        }
                    } else {
                        litery.add(litera.toLowerCase());
                        wystapienia.add(LiteryDTO.builder()
                                .litera(litera.toLowerCase())
                                .ilosc(1)
                                .build());
                    }
                }
            }
        }

    /*
    Przykład.
Ala,,. ma kota!
a - 4
k - 1
l - 1
m - 1
o - 1
t - 1
     */


    /*
   a - 4
   l - 1
   m - 1
   k - 1
   o - 1
   t - 1
     */


        for (LiteryDTO element : wystapienia) {
            wynik.add(element.getLitera() + " - " + element.getIlosc());
        }

        wynik //Zmienna określająca listę Stringów jako wynik, który zostanie zwrócony do użytkownika
                .sort( //metoda sort odpowiada za sortowanie zgodne z kluczem wskazanej listy (wynik)
                        String::compareTo  //Klucz sortowania po którym nasza lista zostanie posortowana
                        //lista zostanie posortowana alfabetycznie w sposób taki, że
                        //zostanie porównany element n z elementem n+1, a następnie zostanie zamieniony zgodnie z
                        //wystąpieniem w alfabecie
                );

    /*
    a - 4
    k - 1
    l - 1
    m - 1
    o - 1
    t - 1
     */

        return wynik;
    }

    //endregion

    //region Zadanie w oparciu o kolekcję Map

    public List<String> getWystapieniaLiterWZdaniuMap(final OneStringRequest request) {
        Map<String, Integer> wystapienia = new HashMap<>();
        List<String> wynik = new ArrayList<>();

        String zdanie = request.getValue().toLowerCase() + request.getValue();

        for (int i = 0; i < zdanie.length(); i++) {
            String litera = String.valueOf(zdanie.charAt(i));

            if(litera.matches("[a-zA-Z]+")) {
                if(wystapienia.containsKey(litera)) {
                    wystapienia.put(litera, wystapienia.get(litera) + 1);
                } else {
                    wystapienia.put(litera, 1);
                }
            }
        }

        for (String element : wystapienia.keySet()) {
            wynik.add(element + " - " + wystapienia.get(element));
        }

        return wynik;
    }
    //endregion
    public String sumaLiczbPomiedzy(final Integer a, final Integer b) {

        Integer wynik = 0;

        if( a > b ) {
            throw new RuntimeException("Wartość parametru A powinna być mniejsza bo wartości parametru b");
        }

        if( a == b ) {
            wynik = a+b;
        } else {

            for (int i = a; i <= b; i++) {
                wynik += i;
            }
        }

        return "Wynik dodawania liczb pomiędzy a: " + a + " oraz b: " + b + " to: " + wynik;
    }


    public String zadanie8(final IntegerListRequest request) {
        List<Integer> listaUjemnych = new ArrayList<>();
        Integer sumaDodatnich = 0;

        for (Integer element :
                request.getIntList()) {
            if (element < 0) {
                listaUjemnych.add(element);
            } else {
                sumaDodatnich += element;
            }
        }

        return listaUjemnych + " oraz suma liczb dodatnich wynosi: " + sumaDodatnich;
    }


}