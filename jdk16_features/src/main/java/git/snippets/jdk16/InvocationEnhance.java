package git.snippets.jdk16;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.ClassLoader.getSystemClassLoader;

/**
 * 反射调用接口的默认方法
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/21
 * @since 16
 */
public class InvocationEnhance {
    public static void main(String[] args) throws Exception {
        invoke();
    }

    static void invoke() throws Exception {
        Object proxy = Proxy.newProxyInstance(getSystemClassLoader(), new Class<?>[]{HelloWorld.class}, (prox, method, args) -> {
            if (method.isDefault()) {
                return InvocationHandler.invokeDefault(prox, method, args);
            }
            // ...
            return prox;
        });
        Method method = proxy.getClass().getMethod("hello");
        System.out.println(method.invoke(proxy).equals("world"));
    }
}

interface HelloWorld {
    default String hello() {
        return "world";
    }
}