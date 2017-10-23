package com.github.johan.backstrom.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = false)
public class QuoteRequestV2 {

    String firstName;
    String lastName;
    int age;
    boolean hasOtherInsurance;
    Gender gender;
    CarBrand carBrand;
    int carValue;
}
