package com.java.version.features.java_17.pseudo;

import java.util.Random;
import java.util.random.RandomGenerator;

public class PseudoRandomNumberGenerator {

    static void main() {
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        System.out.println(randomGenerator.nextInt(100));

        RandomGenerator randomGenerator1 = RandomGenerator.of("L64X128MixRandom");
        System.out.println(randomGenerator1.nextInt(100));

        /**
         * No way to specify the algorithm to use for Random number generation
         * Uses new system architech of modren procerrors with parallel processing so it is very fast
         */
        Random random = new Random();
        System.out.println(random.nextInt(100));
    }
}
