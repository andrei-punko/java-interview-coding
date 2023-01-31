package by.andd3dfx.annotation;

@CustomClassAnnotation(MonthType.SEPTEMBER)
public class SomeAnnotatedClass {

    public String notAnnotatedMethod() {
        return "Hello from notAnnotatedMethod";
    }

    @CustomMethodAnnotation
    public String annotatedMethodWithDefaultAnnotationParameter() {
        return "Hello from annotatedMethodWithDefaultAnnotationParameter";
    }

    @CustomMethodAnnotation(value = 15)
    public String annotatedMethodWithAnnotationParameter() {
        return "Hello from annotatedMethodWithAnnotationParameter";
    }
}
