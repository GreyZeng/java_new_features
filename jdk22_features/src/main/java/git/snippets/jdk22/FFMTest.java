package git.snippets.jdk22;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;


/**
 * FFM API
 * @since 22
 */
public class FFMTest {
    public static void main(String[] args) throws Throwable {
        // 1. Get a lookup object for commonly used libraries
        SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();
        // 2. Get a handle to the "strlen" function in the C standard library
        MethodHandle strlen = Linker.nativeLinker().downcallHandle(stdlib.find("strlen").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS));

        // 3. Get a confined memory area (one that we can close explicitly)
        try (Arena offHeap = Arena.ofConfined()) {

            // 4. Convert the Java String to a C string and store it in off-heap memory
            MemorySegment str = offHeap.allocateFrom("Happy Coding!");

            // 5. Invoke the foreign function
            long len = (long) strlen.invoke(str);
            System.out.println("len = " + len);
        }
        // 6. Off-heap memory is deallocated at end of try-with-resources
    }
}
