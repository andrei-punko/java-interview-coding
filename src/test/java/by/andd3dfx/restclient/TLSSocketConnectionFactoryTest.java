package by.andd3dfx.restclient;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TLSSocketConnectionFactoryTest {

    private TLSSocketConnectionFactory factory;

    @Before
    public void setUp() {
        factory = new TLSSocketConnectionFactory();
    }

    @Test
    public void createSocket() throws IOException {
        final int portNumber = 7945;
        ServerSocket serverSocket = new ServerSocket(portNumber);

        Socket socket = factory.createSocket(null, "127.0.0.1", portNumber, true);

        assertThat(socket, notNullValue());
        serverSocket.close();
    }

    @Test
    public void getDefaultCipherSuites() {
        assertThat(factory.getDefaultCipherSuites(), nullValue());
    }

    @Test
    public void getSupportedCipherSuites() {
        assertThat(factory.getSupportedCipherSuites(), nullValue());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCreateSocketByHostPort() throws IOException {
        factory.createSocket("localhost", 1234);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCreateSocketByAddressPort() throws IOException {
        factory.createSocket(InetAddress.getByName("127.0.0.1"), 1234);
    }

    @Test
    public void testCreateSocketByHostPortLocalHostLocalPort() throws IOException {
        assertThat(factory.createSocket("localhost", 1234, InetAddress.getByName("127.0.0.1"), 4321), nullValue());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCreateSocketByAddressPortLocalAddressLocalPort() throws IOException {
        factory.createSocket(InetAddress.getByName("215.12.12.13"), 1234, InetAddress.getByName("127.0.0.1"), 4321);
    }
}
