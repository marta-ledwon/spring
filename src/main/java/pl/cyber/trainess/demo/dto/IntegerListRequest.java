package pl.cyber.trainess.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;
import java.util.List;


@Getter
public class IntegerListRequest {

    private final List<Integer> intList;

    @ConstructorProperties({"intList"})
    public IntegerListRequest(final List<Integer> intList, final String bbb) {
        this.intList = intList;
    }
}
