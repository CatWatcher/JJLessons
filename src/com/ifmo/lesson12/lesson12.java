package com.ifmo.lesson12;

import java.io.*;

public class lesson12 {

    // скриализация - запись состояния объекта
    // можно записывать в любой поток и считывать
    // inToStrim and OutToStrim

    // как записывать в файл и как передать его на сервер
    //чтобы сериализовать объекты класс объект должен имплементировать интерфейс Serializable

    public static void main(String[] args) {
        File statFile = new File("stat.bin");
        LaunchStat launchStat = null;

        if (!statFile.exists())
            // если первый запуск
            launchStat = new LaunchStat();
        else {
            // если не первый, читаем
            // передаем в конструктор поток
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(statFile))) {
                launchStat = (LaunchStat) objectInputStream.readObject();
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (launchStat.isFirstLaunch()) {
            System.out.println("first");
        } else {
            System.out.println(launchStat);
        }
        // обновляем объект
        launchStat.update();

        //запись объекта
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(statFile))) {
            objOutput.writeObject(launchStat);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
