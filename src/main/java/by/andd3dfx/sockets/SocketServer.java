package by.andd3dfx.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private ServerSocket serverSocket;
    private InputStream socketInputStream;
    private OutputStream socketOutputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
        System.out.println("SERVER: Waiting for a client...");

        Socket socket = serverSocket.accept();              // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
        System.out.println("SERVER: Got a client :) ... Finally, someone saw me through all the cover!");
        System.out.println();

        // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
        socketInputStream = socket.getInputStream();
        socketOutputStream = socket.getOutputStream();

        // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
        dataInputStream = new DataInputStream(socketInputStream);
        dataOutputStream = new DataOutputStream(socketOutputStream);

        String line = null;
        while (true) {
            line = dataInputStream.readUTF();               // ожидаем пока клиент пришлет строку текста.
            System.out.println("SERVER: The client just sent me this line: " + line);
            System.out.println("SERVER: I'm sending it back in uppercase...");
            dataOutputStream.writeUTF(line.toUpperCase());  // отсылаем клиенту обратно ту самую строку текста в uppercase.
            dataOutputStream.flush();                       // заставляем поток закончить передачу данных.
        }
    }
}
