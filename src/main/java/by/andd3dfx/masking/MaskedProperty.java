package by.andd3dfx.masking;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Mark class field to be masked.
 * See also {@link Masked}
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface MaskedProperty {

    /**
     * Pattern to match value (by default the whole value is matched)
     */
    String pattern() default "";

    /**
     * Replacement for value (by default '***')
     */
    String replacement() default "***";
}
