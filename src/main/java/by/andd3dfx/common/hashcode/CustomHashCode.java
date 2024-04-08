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
public class CustomHashCode {

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

        CustomHashCode hashCode = (CustomHashCode) o;
        return intPrimitive == hashCode.intPrimitive
                && Objects.equals(intObject, hashCode.intObject)
                && Objects.equals(string, hashCode.string)
                && Objects.equals(customObject, hashCode.customObject)
                && Objects.equals(integersList, hashCode.integersList)
                && Objects.equals(objectsList, hashCode.objectsList);
    }

    @Override
    public int hashCode() {
        int result = intPrimitive;
        result = 31 * result + (intObject != null ? intObject.hashCode() : 0);
        result = 31 * result + (string != null ? string.hashCode() : 0);
        result = 31 * result + (customObject != null ? customObject.hashCode() : 0);
        result = 31 * result + (integersList != null ? integersList.hashCode() : 0);
        result = 31 * result + (objectsList != null ? objectsList.hashCode() : 0);
        return result;
    }
}
