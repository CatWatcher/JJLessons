package multithreading.synchronize;

import java.util.ArrayList;

public class Counter {
    // общий ресурс
    int counter = 0;

    // метод синхронизации
    // вместо блока
    public synchronized void increment () {
        counter++;
    }
}

class IncrementThread extends Thread {

    Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // блок синхронизация
            // передаем объект доступ к которому нужно синхронизировать доступ
            // не факт что все потоки будут работать по очереди
            // какие-то потоки будут простаивать
            // потокам может вообще не достаться объект
            // на блок тратится много времени
//            synchronized (counter) {
//                counter.counter++;
//            }


            // ипользуем синхронайз метод
            // результат такой же как у блока
            // но тратится меньщше ресурсов
            // использовать только если без них не обойтись
            // лучше использовать пакет для синхронизации
            // либо использовать патокобезопасные коллекции
            counter.increment();
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ArrayList<IncrementThread> threads = new ArrayList<>();

        // создаем потоки
        // 100 потоков
        // и каждый увеличивает каунтер на 1
        for (int i = 0; i < 100; i++) {
            threads.add(new IncrementThread(counter));
        }

        // запуск потоков
        for (IncrementThread thread : threads) {
            thread.start();
        }
        // ждем завершения
        for (IncrementThread thread : threads) {
            thread.join();
        }

        System.out.println("counter = " + counter.counter);
    }
}


