package org.example;

import java.util.concurrent.ThreadLocalRandom;
// генерация random в диапазоне min..max
public class getRandomInRange {
     static int generation(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
