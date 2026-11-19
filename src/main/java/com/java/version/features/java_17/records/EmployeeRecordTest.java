package com.java.version.features.java_17.records;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeRecordTest {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Ravi", new ArrayList<>(Arrays.asList("Chess", "Cricket")));

        System.out.println("employee ="+ employee);

        List<String> skills = employee.skills();
        skills.add("Hockey");

        System.out.println("employee ="+ employee);
    }
}
