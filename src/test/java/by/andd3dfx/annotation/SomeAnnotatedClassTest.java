package by.andd3dfx.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

public class SomeAnnotatedClassTest {

    @Test
    public void testAnnotation() {
        SomeAnnotatedClass someAnnotatedClass = new SomeAnnotatedClass();
        for (Method method : someAnnotatedClass.getClass().getMethods()) {
            CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
            if (annotation != null) {
                System.out.println("Value from annotation on method: " + method.getName() + " is " + annotation.value());
            }
        }
    }
}
