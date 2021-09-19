package ru.netology;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public Server(int port, int numberOfThreads) {

        try (final ServerSocket serverSocket = new ServerSocket(port)) {
            final ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);
            while (true) {
                final Socket socket = serverSocket.accept();
                threadPool.submit(new SocketThread(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
