package be.ucll.apr.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler<T> implements InvocationHandler {
    private T object;

    public LoggingInvocationHandler(T object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(object, args);
    }
}
