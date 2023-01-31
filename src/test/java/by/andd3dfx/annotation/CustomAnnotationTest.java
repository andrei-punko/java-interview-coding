package by.andd3dfx.annotation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomAnnotationTest {

    @Test
    public void annotatedClass() {
        SomeAnnotatedClass someAnnotatedClass = new SomeAnnotatedClass();

        var aClass = someAnnotatedClass.getClass();
        var annotation = aClass.getAnnotation(CustomClassAnnotation.class);
        assertThat(annotation).isNotNull();
        assertThat(annotation.value()).isEqualTo(MonthType.SEPTEMBER);
    }

    @Test
    public void notAnnotatedMethod() throws NoSuchMethodException {
        SomeAnnotatedClass annotatedClass = new SomeAnnotatedClass();

        var method = annotatedClass.getClass().getMethod("notAnnotatedMethod", null);
        var annotation = method.getAnnotation(CustomMethodAnnotation.class);
        assertThat(annotation).isNull();
    }

    @Test
    public void annotatedMethodWithDefaultParameter() throws NoSuchMethodException {
        SomeAnnotatedClass someAnnotatedClass = new SomeAnnotatedClass();

        var method = someAnnotatedClass.getClass().getMethod("annotatedMethodWithDefaultAnnotationParameter", null);
        var annotation = method.getAnnotation(CustomMethodAnnotation.class);
        assertThat(annotation).isNotNull();
        assertThat(annotation.value()).isEqualTo(21);
    }

    @Test
    public void annotatedMethodWithParameter() throws NoSuchMethodException {
        SomeAnnotatedClass someAnnotatedClass = new SomeAnnotatedClass();

        var method = someAnnotatedClass.getClass().getMethod("annotatedMethodWithAnnotationParameter", null);
        var annotation = method.getAnnotation(CustomMethodAnnotation.class);
        assertThat(annotation).isNotNull();
        assertThat(annotation.value()).isEqualTo(15);
    }
}
