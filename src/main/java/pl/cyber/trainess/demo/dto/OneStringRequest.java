package pl.cyber.trainess.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class OneStringRequest {

    private final String value;
    @ConstructorProperties({"value"})
    public OneStringRequest(final String value) {
        if(value==null || value.length() == 0){
            throw new RuntimeException("Nie podano zdania");
        }
        this.value = value;
    }

}
