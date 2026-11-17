package com.java.version.features.java_17.records;

/**
 * A record cannt be inhertied as it is a final class
 */
//public record ChildRecord() extend ParentClazz {
//public record ChildRecord() extend ParentRecord {

//public record ChildRecord() extend Person {

public record ChildRecord() implements ParentInterface {
    @Override
    public void doSomeWork() {
        System.out.println("ChildRecord doSomeWork implementation");
    }
//public record ChildRecord() {
}
