package com.java.version.features.java_17.floatingpoint.strict;

public class RestoreAlwaysStrictFloatingPointSemantics {
    /**
     *
     *
     Restore Always-Strict Floating-Point Semantics (JEP 306)
     🔹 JEP 306 - Restore Always-Strict Floating-Point Semantics
     JEP 306 was introduced to make floating-point arithmetic more predictable and consistent across platforms. It aims to restore strict floating-point semantics to avoid platform-specific discrepancies that could occur in earlier Java versions. This is especially important when the same code can give different results depending on the hardware or operating system.

     ---

     The Problem (Before JEP 306)
     Floating-point operations in Java were sometimes optimized by the CPU or the JVM for performance.
     Some CPUs (e.g., x86) used 80-bit registers (higher precision) in hardware, while others (e.g., ARM) used only 64-bit registers, leading to inconsistent behavior between platforms.
     As a result, calculations involving floating-point numbers could yield different results on different hardware, even with the same Java code.
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        double x = 0.1d + 0.2d;
        System.out.println(x);
        System.out.println("is x == 0.3 = " + (x == 0.3)); // false for some platforms

    }
}
