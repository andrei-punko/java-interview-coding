package by.andd3dfx.core.equalshashcode;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class CustomEqualsNHashCode2Test {

    @Test
    public void testEqualsAndHashCode() {
        EqualsVerifier.simple().forClass(CustomEqualsNHashCode2.class).verify();
    }
}
