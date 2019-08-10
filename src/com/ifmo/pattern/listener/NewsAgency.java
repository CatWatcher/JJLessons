package com.ifmo.pattern.listener;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private List<Listener> listeners = new ArrayList<>();

    public void addListener (Listener listener) {
        listeners.add(listener);
    }

    public void deleteListener (Listener listener) {
        listeners.remove(listener);
    }

    public void someChanges (String message) {
        System.out.println("Message: " + message);
        notifyListeners(message);
    }

    public void notifyListeners (String mess) {
        for (Listener listener: listeners) {
            listener.publish(mess);
        }
    }

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("Listener 1 get Message: " + str);
            }
        });

        agency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("Listener 2: " + str);
            }
        });

        agency.someChanges("Some changes");

    }
}

// чтобы сообщить другим объектам что что-то поменялось
// у одного объекта что-то произошло, вызывается метод паблиш у остальных
// например: изменились данные датчиков - другие объекты реагируют

interface Listener {
    void publish (String str);
}