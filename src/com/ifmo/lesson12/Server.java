package com.ifmo.lesson12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    // если сервер отвалился, то он должен смочь сам подняться
    // но это мы посмотрим позже)
    // отправку и получение сообщений лцучше вынести в отдельный класс

    public Server (int port) {
        this.port = port;
    }

    public void start () throws IOException {
        // сервер ждет входящих подключений
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                getMessage(socket);
            }
        }
    }
    private void getMessage (Socket socket) {
        try (ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream())) {
            Object obj = objIn.readObject();
            printMessage((MessageText) obj);
        }

    }
    private void printMessage(MessageText message) {
        System.out.println("Message: " + message.getMessageText() + " from " + message.getSender());
    }

    // своя точка входа для сервера
    public static void main(String[] args) {
        int port = 8090;
        Server server = new Server(port);
        try{
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
