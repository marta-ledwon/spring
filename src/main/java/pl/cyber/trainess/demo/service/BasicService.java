package pl.cyber.trainess.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.LiteryDTO;
import pl.cyber.trainess.demo.dto.OneStringRequest;
import pl.cyber.trainess.demo.dto.StringRequest;

import java.util.*;

@Service
public class BasicService {


    public String getSklejenie(final StringRequest request) {
        return null;
    }

    public List<String> getWystapieniaLiterWZdaniu(final OneStringRequest request) {
        List<LiteryDTO> wystapienia = new ArrayList<>();
        Set<String> litery = new HashSet<>();
        List<String> wynik = new ArrayList<>();

        String zdanie = request.getValue();

        for (int i = 0; i < zdanie.length(); i++) {
            String litera = String.valueOf(zdanie.charAt(i));

            if (litera.matches("[a-zA-Z]+")) {
                if (wystapienia.size() == 0) {
                    litery.add(litera.toLowerCase());
                    wystapienia.add(new LiteryDTO(litera.toLowerCase(), 1));
                } else {
                    if (litery.contains(litera.toLowerCase())) {
                        for (LiteryDTO element : wystapienia) {
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

        for (LiteryDTO element : wystapienia) {
            wynik.add(element.getLitera() + " - " + element.getIlosc());
        }


        return wynik;
    }

    //zadanie w oparciu o listy
    //region zadanie w oparciu o kolekcje Map

    public List<String> getWystapieniaLiterWZdaniuMap(final OneStringRequest request) {
        Map<String, Integer> wystapienia = new HashMap<>();
        List<String> wynik = new ArrayList<>();

        String zdanie = request.getValue().toLowerCase();

        for (int i = 0; i < zdanie.length(); i++) {
            String litera = String.valueOf(zdanie.charAt(i));

            if (litera.matches("[a-zA-Z]+")) {
                if (wystapienia.containsKey(litera)) {
                    wystapienia.put(litera, wystapienia.get(litera) + 1);
                } else {
                    wystapienia.put(litera, 1);

                }
            }
        }
        for (String element:wystapienia.keySet()) {
            wynik.add(element + " - " + wystapienia.get(element));

        }
        return wynik;
    }

    /*
   region Zadanie5
Napisz zapytanie restowe, którego zadaniem będzie przekazanie liczb a i b (całkowite),
następnie wykona sprawdzenie czy liczba a jest dzielnikiem liczby b i zwróci
informację true lub false
*/



    //endregion
}

