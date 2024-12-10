package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoadBalancer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        System.out.println("Load Balancer started at:"+8080);

        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("TCP connection established with client:"+socket.toString());
            handleSocket(socket);
        }
    }

    private static void handleSocket(Socket socket){
        ClientSocketHandler clientSocketHandler=new ClientSocketHandler(socket);
        Thread clientSocketHandlerThread=new Thread(clientSocketHandler);
        clientSocketHandlerThread.start();
    }
}