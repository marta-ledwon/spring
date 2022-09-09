package pl.cyber.trainess.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter

public class StringRequest {

    private final String stringPierwszy;
    private final String stringDrugi;

    @ConstructorProperties({"stringPierwszy, stringDrugi"})
    public StringRequest(final String stringPierwszy, final String stringDrugi) {
        this.stringPierwszy = stringPierwszy;
        this.stringDrugi = stringDrugi;
    }
}
