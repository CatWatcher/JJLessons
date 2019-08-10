package com.ifmo.lesson12;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    SocketAddress address;
    private Scanner scanner;
    private Connection connection;

    public Client(SocketAddress address, Connection connection) {
        this.address = address;
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        while (true) {
            System.out.println("Enter your message");
            String message = scanner.nextLine();

            try {
                buildAndSend(name, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildAndSend (String name, String message) throws IOException {
        MessageText message1 = new MessageText();
        Socket socket = null;
        try {
            socket = new Socket();

            socket.connect(address);

            try (OutputStream out = socket.getOutputStream(); ObjectOutputStream objOut = new ObjectOutputStream(out)) {

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        finally {
            // нужно закрыть все соединения из блока трай
            socket.close();
        }
    }

    public static void main(String[] args) {

        // считываем данные из конфиг файла
        try (InputStream inputStream =
                     Client.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {


            // для получения данных из проперти файлов
            Properties properties = new Properties();
            properties.load(inputStream);
            // дает значение по ключу
            String server = properties.getProperty("server");
            int port = Integer.parseInt(properties.getProperty("port"));

            

        } catch (IOException e) {
            e.printStackTrace();
        }
        String server = "127.0.0.1";
        int port = 8090;
        Client client = new Client(new InetSocketAddress(server, port));

        Client.start();
    }
}
