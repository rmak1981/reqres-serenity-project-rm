package com.req.res.utils;

import java.util.Random;

/*
 * Ravi's Creation
 * Date of Creation
 */
public class TestUtils {

    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}
