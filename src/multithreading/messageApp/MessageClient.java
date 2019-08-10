package multithreading.messageApp;

import com.ifmo.gym.Client;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient {

    private Scanner in = new Scanner(System.in);
    private  Connection connection;

    public MessageClient (Connection connection) {
        // чтобы можно было использовать методы отправки и чтения сообщений
        this.connection = connection;
    }



    // запускаем поток клиента
    public static void main(String[] args) {
        try {
            MessageClient client = new MessageClient(new Connection(new Socket("127.0.0.1", 8090)));
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void start() throws IOException {
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.println("Enter recipient name: ");
        String recipient = in.nextLine();

        Thread reader = new Thread(new Reader(connection));
        reader.start();

        System.out.println("Enter message: ");
        while (true) {
            String mess = in.nextLine();

            if (mess != null) {
                Message message = new Message(mess, name, recipient);
                connection.sendMessage(message);
            }
        }
    }


    // создаем поток который
    // будет заниматься чтением сообщений
    private class Reader implements Runnable {
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Message message = connection.readMessage();
                    System.out.println(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}


// клиент должен раз в какое - то время пытаться подсоедениться к серверу
// эксепшн выпадать не должен
// тоесть запихать подсоединение в цикл
// подключается - ждет, подключается - ждет и т.д
// так же обработать эксепшн при падении сервера
// просто клиенту выводим сообщение что идет переподключение к серверу
// и соответственно пробьуем переподключиться

// обработать ошибку при закрытии клиента
// если отсоединился клиент, то на сервере удаляем клиента из списка соединений
// и поток должен перестать ждать соединение от этого клиента через интеррапт

// сделать чтобы можно было выбрать кому отправлять сообщение
// отправитель не должен получать свои же сообщения
