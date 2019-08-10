package com.ifmo.lesson12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable {

    private Socket socket;

    private ObjectOutputStream objOut;
    private ObjectInputStream inObj;

    public Connection (Socket socket) throws IOException {

        this.socket = socket;
        // сначала аут, потом ин
        objOut = new ObjectOutputStream(this.socket.getOutputStream());
        inObj = new ObjectInputStream(this.socket.getInputStream());
    }


    public MessageText readMessage () throws IOException, ClassNotFoundException {
        MessageText messageText = (MessageText) inObj.readObject();
        return messageText;
    }

    public void writeMessage (MessageText messageText) throws IOException{
        objOut.writeObject(messageText);
        objOut.flush();
    }

    @Override
    public void close() throws Exception {
        // закрытие ресурсов
        objOut.close();
        inObj.close();
    }
}
