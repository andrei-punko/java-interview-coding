package by.andd3dfx.masking;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marks class to mask its fields marked by {@link MaskedProperty}
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface Masked {
}
