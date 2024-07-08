package by.andd3dfx.core.equalshashcode;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
public class CustomEqualsNHashCode {

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

        var obj = (CustomEqualsNHashCode) o;
        return primitive == obj.primitive
                && Objects.equals(object, obj.object)
                && Objects.equals(customObject, obj.customObject)
                && Objects.equals(collection, obj.collection);
    }

    @Override
    public int hashCode() {
        int result = primitive;
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + (customObject != null ? customObject.hashCode() : 0);
        result = 31 * result + (collection != null ? collection.hashCode() : 0);
        return result;
    }
}
