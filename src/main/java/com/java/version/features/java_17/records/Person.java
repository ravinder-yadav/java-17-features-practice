package com.java.version.features.java_17.records;

/**
 *
 * Record is a special type of class with compact and concise syntax
 * compared to the traditional classes which is designed to hold immutable data
 * and can be used for Data transfer objects
 *
 * it provides constructor and methods
 * getter
 * equals
 * hascode
 * tostring
 *
 * if we want to override the default implementation we can also do that
 *
 * 1) record hold immutable data
 * 2) records is a final class so
 * it cannt be inherited
 *
 *  a record cann't extended any class as it by default extends java.lang.Record
 *  and no additional classes are allowed as java allows only one class
 *  but it can implement multiple interface
 *
 *  all the records are subclasses of java.lang.Record
 *
 * 3) records can have a custom compact constructors
 * a) connaical
 *
 * 4) records can have methods
 *
 * 5) records can have static variables, static methods and static block
 *
 * 6)
 *
 *
 * @param name
 * @param age
 */



public record Person(String name, int age) {

    static int count =0;

    static{
        count = 10;
    }

 /**
  * the below custom compact constructor is equal to below
 * public final class Person extends java.lang.Record{
 *  private final String name;
 *  private final int age;
 * public Person(String name, int age) {
 *         if(age <0) {
 *             throw new IllegalArgumentException("Age is not valid");
 *         }
 *      this.age =age;
 *      this.name = name;
 *     }
 * }
 */

    /**
     *
     *
     *
     The Three Types of Record Constructors

     Records support three constructor forms to handle initialization and validation, as outlined in the Oracle Java Documentation.
     • Canonical Constructor. This constructor has the exact same parameter list as the record's components. The compiler generates it automatically unless you explicitly define it yourself.
     • Compact Constructor. This is a shorthand way to write the canonical constructor without repeating the parameter list or field assignments. It is primarily used for validating or normalizing inputs before the fields are assigned.
     • Non-Canonical (Overloaded) Constructors. These are custom constructors with different parameter lists. They allow you to provide default values or accept alternative input types.

     * @param name
     * @param age
     */

    /**
     * Compact Constructor. This is a shorthand way to write the canonical constructor without repeating the parameter list or field assignments. It is primarily used for validating or normalizing inputs before the fields are assigned.
     * @param name
     * @param age
     */
    public Person {
        if(age <0) {
            throw new IllegalArgumentException("Age is not valid");
        }

        count++;
    }

    /**
     * Can have default zero argument constructor
     * but mandatory to delegate the field initialization and validations through Canonical constructor
     */
    public Person() {
        System.out.println("Default zero argument constructor");

        this("Default Name", 0);
    }

    /**
     * Non-Canonical (Overloaded) Constructors. These are custom constructors with different parameter lists. They allow you to provide default values or accept alternative input types.
     */
    public Person(String name) {
        System.out.println("Default zero argument constructor");
        this(name, 0);
    }

    /**
     * records can have methods
     */
    public void greet() {
        System.out.println("greeting method of person record from ="+ name);
    }

    public boolean isAdult() {
        return age >=18;
    }

    /**
     * records can have static variables, static methods and static block
     */
    public static void printCount() {
        System.out.println("Count = " + count);
    }

}

