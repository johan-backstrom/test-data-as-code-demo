package com.github.johan.backstrom.model;

import java.util.Random;

public enum Gender {
    male,
    female;

    public static Gender getRandomGender(){
        Random random = new Random(System.currentTimeMillis());
        return Gender.values()[random.nextInt(1)];
    }
}
