package by.andd3dfx.dynamic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestoreIPAddressTest {

    private RestoreIPAddress restoreIPAddress;

    @Before
    public void setUp() throws Exception {
        restoreIPAddress = new RestoreIPAddress();
    }

    @Test
    public void restoreIpAddresses() {
        assertThat(restoreIPAddress.restoreIpAddresses("25525511135"))
            .containsExactlyInAnyOrder("255.255.11.135", "255.255.111.35");
        assertThat(restoreIPAddress.restoreIpAddresses("0000"))
            .containsExactlyInAnyOrder("0.0.0.0");
        assertThat(restoreIPAddress.restoreIpAddresses("101023"))
            .containsExactlyInAnyOrder("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
    }
}
