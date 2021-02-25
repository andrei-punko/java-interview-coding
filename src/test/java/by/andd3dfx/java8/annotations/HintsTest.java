package by.andd3dfx.java8.annotations;

import org.junit.Test;

public class HintsTest {

    @Test
    public void testOldApproach() {
        Hint hint = OldApproachPerson.class.getAnnotation(Hint.class);
        System.out.println(hint);                   // null

        Hints hints1 = OldApproachPerson.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);  // 2

        Hint[] hints2 = OldApproachPerson.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);          // 2
    }

    @Test
    public void testNewApproach() {
        Hint hint = NewApproachPerson.class.getAnnotation(Hint.class);
        System.out.println(hint);                   // null

        Hints hints1 = NewApproachPerson.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);  // 2

        Hint[] hints2 = NewApproachPerson.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);          // 2
    }
}
