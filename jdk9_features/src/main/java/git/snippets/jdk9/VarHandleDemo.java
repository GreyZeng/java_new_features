package git.snippets.jdk9;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

/**
 * VarHandler使用
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/14
 * @since 9
 */
public class VarHandleDemo {
    public static void main(String[] args) throws Exception {
        Data instance = new Data();
        System.out.println(instance);
        MethodHandles.privateLookupIn(Data.class, MethodHandles.lookup()).findVarHandle(Data.class, "privateVar", int.class).set(instance, 11);
        MethodHandles.privateLookupIn(Data.class, MethodHandles.lookup()).findVarHandle(Data.class, "publicVar", int.class).set(instance, 22);
        MethodHandles.privateLookupIn(Data.class, MethodHandles.lookup()).findVarHandle(Data.class, "protectedVar", int.class).set(instance, 33);
        VarHandle arrayVarHandle = MethodHandles.arrayElementVarHandle(int[].class);
        arrayVarHandle.compareAndSet(instance.arrayData, 0, 1, 111);
        arrayVarHandle.compareAndSet(instance.arrayData, 1, 2, 222);
        arrayVarHandle.compareAndSet(instance.arrayData, 2, 3, 333);
        System.out.println(instance);
    }
}

class Data {
    public int publicVar = 1;
    protected int protectedVar = 2;
    private int privateVar = 3;
    public int[] arrayData = new int[]{1, 2, 3};

    @Override
    public String toString() {
        return "Data{" + "publicVar=" + publicVar + ", protectedVar=" + protectedVar + ", privateVar=" + privateVar + ", arrayData=" + Arrays.toString(arrayData) + '}';
    }
}
