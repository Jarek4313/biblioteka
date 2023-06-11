package com.jdz.biblioteka.service.util;


import java.util.Random;

public class IsbnNumberUtil {
    public static String generateIsbnNumber() {
        long min = 1000000000000L;
        long max = 10000000000000L;
        Random random = new Random();
        long number = min + ((long)(random.nextDouble()*(max-min)));
        return String.valueOf(number);
    }

    public static int getIsbnNumberNeedCount(int quantityOfBook, int actualIsbnNumberCount) {
        if (quantityOfBook > actualIsbnNumberCount) {
            return quantityOfBook - actualIsbnNumberCount;
        }
        return 0;
    }
}
