package be.ucll.apr.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        var catClass = Class.forName("be.ucll.apr.reflection.Cat"); // Or Cat.class

        // Show all constructors
        System.out.println("Constructors:");
        Arrays.stream(catClass.getConstructors()).forEach(constructor -> {
            var name = constructor.getName();
            var paramCount = constructor.getParameterCount();
            System.out.println("Name: " + name + ", params: " + paramCount);
        });

        // Show all methods
        System.out.println("Methods:");
        Arrays.stream(catClass.getDeclaredMethods()).forEach(method -> {
            var name = method.getName();
            var paramCount = method.getParameterCount();
            System.out.println("Name: " + name + ", params: " + paramCount);
        });

        // Create a cat named Bagheera through reflection
        Constructor<?> catConstructor = catClass.getConstructor(String.class);
        Object cat = catConstructor.newInstance("Bagheera");

        // Call the getName method through reflection
        Method getName = catClass.getMethod("getName");
        System.out.println(getName.invoke(cat));

        // Call the setName method through reflection
        Method setName = catClass.getMethod("setName", String.class);
        setName.invoke(cat, "Luna");
        System.out.println(((Cat)cat).getName());

        // Get annotations
        Arrays.stream(catClass.getAnnotations()).forEach(annotation -> {
            System.out.println("Annotation: " + annotation);
        });

        // Create a proxy object
        var originalMap = new HashMap<String, String>();
        var loggingInvocationHandler = new LoggingInvocationHandler<>(originalMap);
        var proxyMap = (Map<String, String>) Proxy.newProxyInstance(
                Map.class.getClassLoader(),
                new Class[]{ Map.class },
                loggingInvocationHandler);
        proxyMap.put("Key", "Value");
        System.out.println(proxyMap.get("Key"));
    }
}
