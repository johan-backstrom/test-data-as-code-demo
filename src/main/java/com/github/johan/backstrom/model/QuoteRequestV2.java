package com.github.johan.backstrom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteRequestV2 {

    String firstName;
    String lastName;
    int age;
    boolean hasOtherInsurance;
    Gender gender;
    CarBrand carBrand;
    int carValue;
}
