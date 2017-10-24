package com.github.johan.backstrom.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.johan.backstrom.common.DocumentBuilder;
import com.github.johan.backstrom.common.core.Attribute;
import com.github.johan.backstrom.common.standard.StandardAttribute;
import com.github.johan.backstrom.model.CarBrand;
import com.github.johan.backstrom.model.Gender;


import java.util.Map;
import java.util.Random;

public class QuoteRequestBuilder {

    DocumentBuilder documentBuilder = new DocumentBuilder();

    private Attribute<String> name = new StandardAttribute<String>(
            "firstName",
            params -> (params.get("gender").getValue()).equals(Gender.male) ? "Göran" : "Lena"
    );

    private Attribute<Integer> age = new StandardAttribute<Integer>(
            "age",
            params -> params.get("carBrand").getValue().equals(CarBrand.Ferrari) ? 40 : 55
    );

    public QuoteRequestBuilder setAge(int age){
        this.age.setValue(age);
        return this;
    }

    private Attribute<Boolean> hasOtherInsurance = new StandardAttribute<Boolean>(
            "hasOtherInsurance",
            params -> Math.random() > 0.5
    );

    public QuoteRequestBuilder setHasOtherInsurance(boolean hasOtherInsurance){
        this.hasOtherInsurance.setValue(hasOtherInsurance);
        return this;
    }

    private Attribute<Gender> gender = new StandardAttribute<Gender>(
            "gender",
            params -> Gender.getRandomGender()
    );

    private Attribute<CarBrand> carBrand = new StandardAttribute<CarBrand>(
            "carBrand",
            params -> CarBrand.getRandomCarBrand()
    );

    public QuoteRequestBuilder setCarBrand(CarBrand carBrand){
        this.carBrand.setValue(carBrand);
        return this;
    }

    private Attribute<Integer> carValue = new StandardAttribute<Integer>(
            "carValue",
            params -> params.get("carBrand").getValue().equals(CarBrand.Ferrari) ? 1500000 : 30000
    );

    public QuoteRequestBuilder setGender(Gender gender){
        this.gender.setValue(gender);
        return this;
    }

    /*
    {
        "name": "apan",
            "age": 30,
            "hasOtherInsurance": true,
            "gender": "male",
            "carBrand": "Volvo",
            "carValue": 400000
    }
*/

    public QuoteRequestBuilder(){
        documentBuilder.addAttribute(name);
        documentBuilder.addAttribute(age);
        documentBuilder.addAttribute(hasOtherInsurance);
        documentBuilder.addAttribute(gender);
        documentBuilder.addAttribute(carBrand);
        documentBuilder.addAttribute(carValue);
        documentBuilder.addDependency(name, gender);
        documentBuilder.addDependency(carValue, carBrand);
        documentBuilder.addDependency(age, carBrand);
    }

    public String createQuote(){
        documentBuilder.buildDataForEmptyAttributes();
        try {
            return new ObjectMapper().writeValueAsString(documentBuilder.toMap());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
