package com.java.version.features.java_17.records;

import java.util.List;

/**
 * The record class is a immutable only when the parameters are immutable
 * for examlple in this case List is a mutable class instance then will be able
 * to modify the record as shown in the Employee record test class
 *
 *
 * @param id
 * @param name
 * @param skills
 */
public record Employee(int id, String name, List<String> skills) {

}
