package com.github.johan.backstrom.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteRequestV1 {

    String name;
    int age;
    boolean hasOtherInsurance;
    Gender gender;
    CarBrand carBrand;
    int carValue;
}
