package com.tokioschol.codelabkotlin.data.utils;

import java.util.Random;

public abstract class RandonUtils {

    static Random random = new Random();

    private RandonUtils() {
        //utility class
    }

    public static int getRandonAge(){
        int upperbound = 101;
        return random.nextInt(upperbound);
    }

    public static String randomNameOrSurname(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
