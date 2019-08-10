package multithreading.messageApp;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// отвечает за получение и отправку сообщений
public class Connection {

    // Выходной поток для объектов
    // тк наше сообщение это объект
    private ObjectOutputStream out;

    // Входной поток для объектов
    private ObjectInputStream in;

    // пара из порта и протокола?
    private Socket socket;

    // конструктор соединения
    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    // чтение сообщений
    // через входной поток получаем сообщение и приводим его к типу Message
    public Message readMessage() throws IOException, ClassNotFoundException{
        return (Message) in.readObject();
    }

    // Отправка сообщений
    // отправляем сообщение через выходной поток
    // и флашим поток, чтобы сообщение записалось
    public void sendMessage (Message message) throws IOException{
        out.writeObject(message);
        out.flush();
    }

}