package git.snippets.jdk19;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.SegmentAllocator.implicitAllocator;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

/**
 * FFM API
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/9/22
 * @since 19
 */
public class FFMTest {
    public static void main(String[] args) throws Throwable {
        // 1. Get a lookup object for commonly used libraries
        SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();

        // 2. Get a handle to the "strlen" function in the C standard library
        MethodHandle strlen = Linker.nativeLinker().downcallHandle(
                stdlib.lookup("strlen").orElseThrow(),
                FunctionDescriptor.of(JAVA_LONG, ADDRESS));

        // 3. Convert Java String to C string and store it in off-heap memory
        MemorySegment str = implicitAllocator().allocateUtf8String("Happy Coding!");

        // 4. Invoke the foreign function
        long len = (long) strlen.invoke(str);

        System.out.println("len = " + len);
    }
}
