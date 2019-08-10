package multithreading.pool.synchronises;

import java.util.concurrent.Semaphore;

// обозначает сколько потоков может иметь доступ к ресурсу
// чтобы обратиться к ресурсу поток спрашивает разрешение у семафора
// когда поток закончил пользоваться ресурсом
// нужно чтобы он его отпустил
public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new IncrementThread("Increment", semaphore);
        new DecrementThread("Decrement", semaphore);
    }
}

// общий ресурс
class Counter {
    static int count = 0;
}

// если юзаем симофор, то синхронизация нигде не пишется
class IncrementThread implements Runnable {

    String name;
    Semaphore semaphore;

    public IncrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start of work " + name);

        try {
            System.out.println("Ожидание разрешения " + name);

            // тут меняем число разрешений
            semaphore.acquire();
            System.out.println("Thread" + name + "доступ получен");

            for (int i = 0; i < 5; i++) {
                Counter.count++;
                System.out.println("Counter count = " + Counter.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + name + "потоку больше не нужно разрешение");

        // освобождение разрешений
        semaphore.release();

    }
}

class DecrementThread implements Runnable {

    String name;
    Semaphore semaphore;

    public DecrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start of work " + name);

        try {
            System.out.println("Ожидание разрешения " + name);

            // тут меняем число разрешений
            semaphore.acquire();
            System.out.println("Thread" + name + "доступ получен");

            for (int i = 0; i < 5; i++) {
                Counter.count--;
                System.out.println("Couner cont = " + Counter.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + name + "потоку больше не нужно разрешение");

        // освобождение разрешений
        semaphore.release();

    }
}