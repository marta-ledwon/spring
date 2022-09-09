package pl.cyber.trainess.demo.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainess.demo.dto.OneStringRequest;
import pl.cyber.trainess.demo.dto.StringRequest;
import pl.cyber.trainess.demo.service.BasicService;
import pl.cyber.trainess.demo.service.KalkulatorService;
import pl.cyber.trainess.demo.service.ZnajdzSerwis;

import java.util.List;

@RestController
@RequestMapping("/v1/basics")
@RequiredArgsConstructor
public class BasicController {

    /* Zadanie1
    Napisać zapytania dla porostego kalkulatora, ktory bedzie obslugiwac 5 operacji
    (każda z nich powinna byc oddzielnym zapytaniem restowym)
    Operacje dodawnaia odejmowanie mnozenia i dzielenia oraz obliczenie reszty z dzielenia

    Zwrocic wynik naszych operacji
     */
    private final KalkulatorService kalkulatorService;
    private final BasicService basicsService;

    private final ZnajdzSerwis znajdzSerwis;


    @GetMapping("/dodawanie/{a}/{b}")
    public Integer getDodawanie(@PathVariable("a") final Integer liczbaA,
                                @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getDodawanie(liczbaA, liczbaB);
    }

    @GetMapping("/dodawanieParams") //http://localhost:8150/demo/v1/basics/dodawanieParams?a=100&b=200
    public Integer getDodawanieParams(@RequestParam("a") final Integer liczbaA,
                                      @RequestParam("b") final Integer liczbaB) {
        return kalkulatorService.getDodawanie(liczbaA, liczbaB);
    }

    @GetMapping("/odejmowanie/{a}/{b}")
    public Integer getOdejmowanie(@PathVariable("a") final Integer liczbaA,
                                  @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getOdejmowanie(liczbaA, liczbaB);
    }

    @GetMapping("/mnozenie/{a}/{b}")
    public Integer getMnozenie(@PathVariable("a") final Integer liczbaA,
                               @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getMnozenie(liczbaA, liczbaB);
    }

    @GetMapping("/dzielenie/{a}/{b}")
    public Integer getDzielenie(@PathVariable("a") final Integer liczbaA,
                                @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getDzielenie(liczbaA, liczbaB);
    }

    @GetMapping("/reszta/{a}/{b}")
    public Integer getReszta(@PathVariable("a") final Integer liczbaA,
                             @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getReszta(liczbaA, liczbaB);
    }

    //zadanie 2
    /*
    Napisz zapytanie restowe ktorego zadnaiem bedzie wykonanie sprawdzenia
    czy przekazana liczba jest liczba pierwsza
     */
    @GetMapping("/pierwsza/{a}")
    public String getLiczbaPierwsza(@PathVariable("a") final Integer a) {
        return kalkulatorService.getLiczbaPierwsza(a);
    }

    /*
    zadanie 3
    napisz zapytanie restowe ktorego zadaniem bedzie wykonaie sklejenia dwoch stringow
    przekazanych jako Request Body a nastepnie zwroci wynik(mozna uzyc PostMapping)
    POST/PUT
     */
    @PostMapping("/sklejenie-stringow")
    public String getSklejenie(
            @RequestBody final StringRequest request
    ) {

        return basicsService.getSklejenie(request);
    }
//    region Zadanie4
/*Napisz zapytanie restowe, którego zadaniem będzie przyjęcie napisu  jako zdania
(przekazanych jako RequestBody)
 Program powinien policzyć ilość wystąpień poszczególnych liter zdania i zwrócić
 odpowiednio przygotowane dane.
Uwaga należy pominąć litery, których w zdaniu nie ma oraz wszystkie znaki puste.

Przykład.
Ala ma kota

a - 4
k - 1
l - 1
m - 1
o - 1
t - 1
*/
/*
@PostMapping
@RequestBody
 */

    @PostMapping("/zliczanie")
    public List<String> getWystapieniaLiterWZdaniuMap(
            @RequestBody final OneStringRequest request
    ) {
        return basicsService.getWystapieniaLiterWZdaniuMap(request);
    }
//region Zadanie5
/*
Napisz zapytanie restowe, którego zadaniem będzie przekazanie liczb a i b (całkowite),
następnie wykona sprawdzenie czy liczba a jest dzielnikiem liczby b i zwróci
informację true lub false
*/

    @GetMapping("/dzielnik/{a}/{b}")
    public boolean getDzielnik(@PathVariable("a") final Integer liczbaA,
                               @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getDzielnik(liczbaA, liczbaB);
    }

    @GetMapping("/znajdz/{a}")
    public String znajdzLiczbe(
            @PathVariable("a") final Integer liczba
    ) {
        return znajdzSerwis.znajdzLiczbe(liczba);

    }
//region Zadanie7
  /*
  Napisz program, w którym zostaną przekazane liczby a i b (całkowite) następnie
  zostaną zsumowane wszystkie liczby pomiędzy od a do b
  (jako przedział zamknięty dwustronnie).
  Przykład podajemy: 1 do 10 czego wynikiem będzie 55

  GET, PATHVARIABLE

  */

//besicsService

//endregion

//region Zadanie8
    /*POST,, REQUESTBODY
    //UTWORZYC KLASE DTO IntegerListRequest >>> list<integer>
    //jason:
    {
    "lista": [1,2,3,4,5,6,7,8]

    if do sprawdzenia czy liczba z listy jest ujemna czy dodatnia
    */
  /*Napisz program, w krótym przekażemy listę elementów liczb całkowitych program
  powinien zwrócić listę elementów z wartościami ujemnymi oraz sumę liczb,
  które są dodatnie.
  Np. [1, 2, 3, 4, 5, -3, -2, -1]
  wynik:
  [-3, -2, -1] oraz suma liczb dodatnich wynosi: 15
  */

//besicsService
//endregion

//region zadanie9
    /*
    Napisz zapytanie restowe, którego zadaniem będzie obliczał pierwiastek
    równania kwadratowego ax2 + bx + c = 0.
    (Do wykożystania instrukcja if). Pamiętać należy że zmienne a, b i c to
    liczby rzeczywiste.
    Zadanie powinno zwrócić Napis:
    a) To nie jest równanie kwadratowe
    b) Brak pierwiastków
    c) Jeden pierwiastek. Wynik: xxxx
    d) Dwa pierwiastki. Wynik -> x1: xxxx, x2: xxxx
     */

    //KalkulatorService
    //endregion


}
