package by.andd3dfx.common.hashcode;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
public class CustomHashCode2 {

    private int intPrimitive;
    private Integer intObject;
    private String string;
    private Field customObject;
    private List<Integer> integersList;
    private List<Field> objectsList;

    @Data
    public class Field {
        private int value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomHashCode2 hashCode2 = (CustomHashCode2) o;
        return intPrimitive == hashCode2.intPrimitive
                && Objects.equals(intObject, hashCode2.intObject)
                && Objects.equals(string, hashCode2.string)
                && Objects.equals(customObject, hashCode2.customObject)
                && Objects.equals(integersList, hashCode2.integersList)
                && Objects.equals(objectsList, hashCode2.objectsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intPrimitive, intObject, string, customObject, integersList, objectsList);
    }
}
