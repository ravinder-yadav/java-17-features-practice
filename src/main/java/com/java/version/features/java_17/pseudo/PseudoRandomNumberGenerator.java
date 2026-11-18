package com.java.version.features.java_17.pseudo;

import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class PseudoRandomNumberGenerator {

    public static void main(String[] args) {
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

        System.out.println("##############################");

        // Different PRNG algorithms
        var random1 = RandomGenerator.of("L128X1024MixRandom");
        var random2 = RandomGenerator.of("Xoshiro256PlusPlus");

        // Stream of random integers
        random1.ints(10, 1, 100)
                .forEach(System.out::println);
        System.out.println("##############################");
        // Multiple streams
        RandomGenerator.SplittableGenerator splittableRng =
                RandomGeneratorFactory.<RandomGenerator.SplittableGenerator>of("L128X1024MixRandom")
                        .create();

        splittableRng.splits(4)
                .parallel()
                .forEach(rng -> {
                    // Each thread gets its own RNG
                    System.out.println(Thread.currentThread().getName() + ": " + rng.nextInt());
                });
    }
}
