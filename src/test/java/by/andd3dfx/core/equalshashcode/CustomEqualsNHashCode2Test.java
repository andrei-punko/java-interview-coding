package by.andd3dfx.core.equalshashcode;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class CustomEqualsNHashCode2Test {

    @Test
    public void testEqualsNHashCode() {
        EqualsVerifier.simple().forClass(CustomEqualsNHashCode2.class).verify();
    }
}
