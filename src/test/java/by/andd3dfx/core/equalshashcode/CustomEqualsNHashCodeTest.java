package by.andd3dfx.core.equalshashcode;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class CustomEqualsNHashCodeTest {

    @Test
    public void testEqualsNHashCode() {
        EqualsVerifier.simple().forClass(CustomEqualsNHashCode.class).verify();
    }
}
