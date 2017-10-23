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
    public void volvoCosts1000() {
        assertThat(
                carInsuranceController.getQuote(
                        QuoteRequestV1.builder()
                                .age(30)
                                .carBrand(CarBrand.Volvo)
                                .carValue(300000)
                                .gender(Gender.male)
                                .hasOtherInsurance(true)
                                .name("Göran")
                                .build()

                ).getBody().getPricePerYear(),
                is(1000)
        );
    }

    @Test
    public void getDiscountWithVolvoAndOtherInsurance() {
        assertThat(
                carInsuranceController.getQuote(
                        QuoteRequestV1.builder()
                                .age(51)
                                .carBrand(CarBrand.Volvo)
                                .carValue(300000)
                                .gender(Gender.male)
                                .hasOtherInsurance(true)
                                .name("Göran")
                                .build()

                ).getBody().getDiscount(),
                is(100)
        );
    }
}