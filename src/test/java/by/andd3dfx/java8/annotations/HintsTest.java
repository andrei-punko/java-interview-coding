package by.andd3dfx.java8.annotations;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HintsTest {

    @Test
    public void testOldApproach() {
        Hint hint = OldApproachPerson.class.getAnnotation(Hint.class);
        assertThat(hint).isNull();

        Hints hints1 = OldApproachPerson.class.getAnnotation(Hints.class);
        assertThat(hints1.value().length).isEqualTo(2);

        Hint[] hints2 = OldApproachPerson.class.getAnnotationsByType(Hint.class);
        assertThat(hints2.length).isEqualTo(2);
    }

    @Test
    public void testNewApproach() {
        Hint hint = NewApproachPerson.class.getAnnotation(Hint.class);
        assertThat(hint).isNull();

        Hints hints1 = NewApproachPerson.class.getAnnotation(Hints.class);
        assertThat(hints1.value().length).isEqualTo(2);

        Hint[] hints2 = NewApproachPerson.class.getAnnotationsByType(Hint.class);
        assertThat(hints2.length).isEqualTo(2);
    }
}
