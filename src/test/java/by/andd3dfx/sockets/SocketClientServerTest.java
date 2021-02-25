package by.andd3dfx.sockets;

import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class SocketClientServerTest {

    private static SocketServer server = new SocketServer();
    private static SocketClient client = new SocketClient();

    @Test
    public void test() throws InterruptedException {
        Thread serverThread = new Thread(() -> {
            try {
                server.start(12345);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        Thread clientThread = new Thread(() -> {
            try {
                client.start(12345, "127.0.0.1");
                client.transmit("src/test/resources/file-to-send-via-socket.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        clientThread.start();

        sleep(100);
    }
}