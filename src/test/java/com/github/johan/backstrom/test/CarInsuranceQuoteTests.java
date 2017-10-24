package com.github.johan.backstrom.test;

import com.github.johan.backstrom.CarInsuranceControllerV1;
import com.github.johan.backstrom.model.CarBrand;
import com.github.johan.backstrom.model.Gender;
import com.github.johan.backstrom.model.QuoteRequestV1;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CarInsuranceQuoteTests {

    CarInsuranceControllerV1 carInsuranceController = new CarInsuranceControllerV1();

    @Test
    public void volvoCostsJson(){
        System.out.println(
                new QuoteRequestBuilder()
                        .setGender(Gender.female)
                        .setAge(60)
                        .createQuote()
        );
    }
}