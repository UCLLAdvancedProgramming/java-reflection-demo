package be.ucll.apr.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// The information of this annotation can be retrieved at runtime
@Retention(RetentionPolicy.RUNTIME)
// This annotation can apply to a type (e.g. a class)
@Target({ElementType.TYPE})
public @interface Animal {
    int numberOfFeet();
}
