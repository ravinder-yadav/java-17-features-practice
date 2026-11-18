package com.java.version.features.java_17.ffm;

import jdk.incubator.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class FfmJava17Example {
    public static void main(String[] args) throws Throwable {
        // 1. Obtain a linker and lookup the C standard library's 'strlen' function
        CLinker linker = CLinker.getInstance();
        SymbolLookup stdlib = CLinker.systemLookup();
        MemoryAddress strlenAddr = stdlib.lookup("strlen").orElseThrow();

        // 2. Define the Java MethodType and C FunctionDescriptor
        // size_t strlen(const char *s)
        MethodHandle strlen = linker.downcallHandle(
                strlenAddr,
                MethodType.methodType(long.class, MemoryAddress.class),
                FunctionDescriptor.of(CLinker.C_LONG, CLinker.C_POINTER)
        );

        // 3. Allocate off-heap memory safely within a ResourceScope
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            // Convert a Java String into a null-terminated C string in native memory
            MemorySegment cString = CLinker.toCString("Hello from Java 17 FFM!", scope);

            // 4. Invoke the native C function
            long length = (long) strlen.invokeExact(cString.address());
            System.out.println("Native strlen result: " + length);
        } // Native memory is automatically freed when the scope closes
    }
}
