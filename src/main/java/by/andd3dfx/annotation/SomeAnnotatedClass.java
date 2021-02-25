package by.andd3dfx.annotation;

public class SomeAnnotatedClass {

    public void notAnnotatedMethod() {
        System.out.println("Hello from notAnnotatedMethod");
    }

    @CustomAnnotation
    public void annotatedMethodWithDefaultParameter() {
        System.out.println("Hello from annotatedMethodWithDefaultParameter");
    }

    @CustomAnnotation(value = 15)
    public void annotatedMethodWithParameter() {
        System.out.println("Hello from annotatedMethodWithParameter");
    }
}
