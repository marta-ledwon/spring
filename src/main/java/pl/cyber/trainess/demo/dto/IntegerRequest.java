package pl.cyber.trainess.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class IntegerRequest {

    private final Integer parametrA;

    @ConstructorProperties({""})
}
