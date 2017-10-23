package com.github.johan.backstrom;

import com.github.johan.backstrom.model.QuoteRequestV1;
import com.github.johan.backstrom.model.QuoteRequestV2;
import com.github.johan.backstrom.model.QuoteResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.github.johan.backstrom.model.CarBrand.Ferrari;
import static com.github.johan.backstrom.model.CarBrand.Volvo;

@RestController
@RequestMapping("/v2")
public class CarInsuranceControllerV2 {

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            path = "/quote"
    )
    public ResponseEntity<QuoteResponse> getQuote(@RequestBody QuoteRequestV2 quoteRequest){

        if (quoteRequest.getFirstName() == null){
            throw new ImATeapotException("firstName is mandatory!");
        }

        if (quoteRequest.getCarBrand().equals(Ferrari) && quoteRequest.getCarValue() < 1000000) {
            throw new ImATeapotException("A Ferrari costs at least 1000000!");
        }

        if (quoteRequest.getCarBrand().equals(Volvo) && quoteRequest.getCarValue() >= 1000000) {
            throw new ImATeapotException("That Volvo is just too expensive!");
        }

        if (quoteRequest.getCarBrand().equals(Ferrari) && quoteRequest.getAge() > 70) {
            throw new ImATeapotException("You're too old to drive a Ferrari!");
        }

        int pricePerYear;
        int discount = 0;
        String magazine;

        if (quoteRequest.getCarBrand().equals(Ferrari)) {
            pricePerYear = 10000;
        } else {
            pricePerYear = 1000;
        }

        if (quoteRequest.getAge() > 50) {
            magazine = "Classic Car";
        } else {
            magazine = "Sporty car";
        }

        if (quoteRequest.getCarBrand().equals(Volvo) && quoteRequest.isHasOtherInsurance()){
            discount = 200;
        }

        return ResponseEntity.ok(
                QuoteResponse.builder()
                        .pricePerYear(pricePerYear)
                        .magazine(magazine)
                        .discount(discount)
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public class ImATeapotException extends RuntimeException {
        ImATeapotException(String message) {
            super(message);
        }
    }

}
