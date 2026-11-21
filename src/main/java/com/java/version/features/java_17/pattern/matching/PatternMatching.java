package com.java.version.features.java_17.pattern.matching;

public class PatternMatching {

    public static void main(String[] args) {
        Object object = new LocationRecord(1,2);
        if (object instanceof String) {
            String s = (String) object;
            System.out.println(s.toUpperCase());
        } else if(object instanceof Integer) {
            //String s = (String) object;
            Integer i = (Integer) object;

            System.out.println(i*2);

        }

        /**
         * After pattern matching
         *
         * Type checking + Type casting + Variable declaration all done in single step
         * thus avoiding the manual casting issue and also allowing to do addition condition checks
         */

        if (object instanceof String s) {
            System.out.println(s.toUpperCase());
        } else if(object instanceof Integer i && i >=10) {
            System.out.println(i*2);
        }
        /*else if(object instanceof Integer i || i >=10) {
            System.out.println(i*2);
        }*/

        /**
         *
         * Pattern matching for Switch Case or Switch Expression
         *
         * 1) pattern Type matching
         * 2) gaurd rails (condition checking in case)
         * 3) null case
         */


        switch (object) {
            case LocationRecord l && l.x() >0 && l.y() >0 -> System.out.println("x = "+ l.x()+ " y = " + l.y());
            //case String s -> System.out.println(s.toUpperCase());
            case String s && s.length() >= 5 -> System.out.println(s.toUpperCase());
            //case Integer i -> System.out.println(i*2);
            case Integer i && i >= 10 -> System.out.println(i*2);
            case null -> System.out.println("object is null");
            default -> System.out.println("default case");
        }
    }
}
