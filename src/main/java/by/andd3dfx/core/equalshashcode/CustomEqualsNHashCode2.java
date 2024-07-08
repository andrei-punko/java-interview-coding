package by.andd3dfx.core.equalshashcode;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
public class CustomEqualsNHashCode2 {

    private int primitive;
    private String object;
    private Field customObject;
    private List<Integer> collection;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        var obj = (CustomEqualsNHashCode2) o;
        return primitive == obj.primitive
                && Objects.equals(object, obj.object)
                && Objects.equals(customObject, obj.customObject)
                && Objects.equals(collection, obj.collection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primitive, object, customObject, collection);
    }
}
