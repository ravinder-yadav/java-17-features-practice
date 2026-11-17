package com.java.version.features.java_17.records;

public class PersonRecordTest {
    static void main() {
        Person person = new Person("Ravi", 48);

        System.out.println("Name = " + person.name());
        System.out.println("Age = " + person.age());

        System.out.println("person tostring method = " + person.toString());


        Person person1 = new Person("Ravi", 48);

        System.out.println("person hashcode = " + person.hashCode());
        System.out.println("person1 hashcode = " + person1.hashCode());


        System.out.println("persons are equal = " + person.equals(person1));

        Person person2 = new Person("Ravi", 20);
        person2.greet();
        System.out.println("is Person Adult =" + person2.isAdult());

        person2.printCount();

        Person person3 = new Person("Ravi", -1);
        System.out.println("person2 =" + person3.toString());
    }
}
