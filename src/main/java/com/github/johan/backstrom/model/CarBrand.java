package com.github.johan.backstrom.model;

import java.util.Random;

public enum CarBrand {
    Ferrari,
    Volvo;

    public static CarBrand getRandomCarBrand(){
        Random random = new Random(System.currentTimeMillis());
        return CarBrand.values()[random.nextInt(1)];
    }
}
