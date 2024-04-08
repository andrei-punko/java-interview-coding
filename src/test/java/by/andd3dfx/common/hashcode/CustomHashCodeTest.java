package by.andd3dfx.common.hashcode;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomHashCodeTest {

    private final CustomHashCode OBJ1 = CustomHashCode.builder()
            .intPrimitive(12)
            .integersList(List.of(1, 2))
            .build();
    private final CustomHashCode OBJ2 = CustomHashCode.builder()
            .intPrimitive(13)
            .integersList(List.of(2, 3))
            .build();
    private final CustomHashCode OBJ3 = CustomHashCode.builder()
            .intPrimitive(12)
            .integersList(List.of(1, 2))
            .build();
    
    @Test
    public void testHashCode() {
        assertThat(OBJ1.hashCode()).isNotEqualTo(OBJ2.hashCode());
        assertThat(OBJ1.hashCode()).isEqualTo(OBJ3.hashCode());
    }

    @Test
    public void testEquals() {
        // Object equals to itself
        assertThat(OBJ1.equals(OBJ1)).isTrue();
        assertThat(OBJ2.equals(OBJ2)).isTrue();
        assertThat(OBJ3.equals(OBJ3)).isTrue();

        // Different objects, different classes
        assertThat(OBJ1.equals("OBJ1")).isFalse();
        assertThat(OBJ2.equals("OBJ2")).isFalse();
        assertThat(OBJ3.equals("OBJ3")).isFalse();

        // Different objects, same class
        assertThat(OBJ1.equals(OBJ2)).isFalse();
        assertThat(OBJ2.equals(OBJ1)).isFalse();

        // Equal objects
        assertThat(OBJ1.equals(OBJ3)).isTrue();
        assertThat(OBJ3.equals(OBJ1)).isTrue();
    }
}
