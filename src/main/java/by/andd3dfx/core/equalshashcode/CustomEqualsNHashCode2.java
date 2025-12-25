package by.andd3dfx.core.equalshashcode;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * @see <a href="https://youtu.be/tV621E_36Y4">Video solution</a>
 */
@Getter
@Setter
public class CustomEqualsNHashCode2 {

    private int primitive;
    private String objectField;
    private Field customObject;
    private List<Integer> collectionField;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        var that = (CustomEqualsNHashCode2) o;
        return primitive == that.primitive
            && Objects.equals(objectField, that.objectField)
            && Objects.equals(customObject, that.customObject)
            && Objects.equals(collectionField, that.collectionField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primitive, objectField, customObject, collectionField);
    }
}
