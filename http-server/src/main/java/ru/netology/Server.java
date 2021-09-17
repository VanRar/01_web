package ru.netology;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 8888;
    private static final int NUMBER_OF_THREADS = 64;

    public Server() {
        try (final ServerSocket serverSocket = new ServerSocket(PORT)){
            final ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
            while (true){

                final Socket socket = serverSocket.accept();
                threadPool.submit(new SocketThread(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
