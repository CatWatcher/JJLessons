package multithreading;

public class MultiThreadExample {

    // у каждого потока свой стек, но общая кучу

    // start() - запуск потока
    // Thread.currentThread - получение текущего потока
    // setName(name) - задать имя потока
    // getName() - получить имя потока
    // getState() - возвращает текущее состояние потока
    // isAlive()  - запущен или не запущен (тру ор фолс)

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

        // создаем объект
        Thread myThread = new MyThread();
        // запуск потока
        // начинает работать функционал метода ран
        // когда инструкции кончаются, поток завершается
        myThread.start();

        // приостановка потока
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }

        // если создавали через интерфейс
        Thread thread1 = new Thread(new OtherThread("One"));
        Thread thread2 = new Thread(new OtherThread("Two"));
        Thread thread3 = new Thread(new OtherThread("Three"));

        thread1.start();
        thread2.start();
        thread3.start();

        // если нужно чтобы обязательно завершились другие потоки, и только потом завершался основной
        // основной поток будет ждать остальные
        // вызывается в основном потоке
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // инициализация анонимным классом
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                // тру или фолс запущен или не запущен
                System.out.println("Running: " + Thread.currentThread().isAlive());
                // возвращает состояние потока
                System.out.println("Running: " + Thread.currentThread().getState());
            }
        });

        thread4.start();

        Thread whileThread = new WhileThread();
        whileThread.start();
        // чтобы этот поток завершился после основного
        // ! только если полностью осознаем зачем это надо!
        whileThread.setDaemon(true);
        thread4.setDaemon(true);


        //////////// прерывание потоков /////////////////////
        // поток останавливается в следующих случаях:
        //
        // - Если поток выполнил все свои инструкции
        // - Если в потоке было выброшено необрабатываваемое исключение
        // (при этом остальные потоки продолжат работать)
        // - Остановилась JVM
        // - Если это демон и основной поток завершился

        /////////// механизм прерывания /////////
        // 1:
        // у каждого потока есть флаг прерван или нет
        // это хначение можно проверить методом
        // isInterrupted - true or false
        // .interrupt() - устанавливает значение флага в тру ор фолс
        //

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        });

        thread5.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread5.interrupt();



        System.out.println("Завершение основного потока");
    }
}

class WhileThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Demons!");
        }
    }
}
// создание класса потока
// наследование от Thread
class MyThread extends Thread {
    // тут функционал потока
    // чтобы поток выполнялся переопределяем метод ран


    @Override
    public void run() {
        Thread.currentThread().setName("MyThread");
        System.out.println(Thread.currentThread().getName());
    }
}

// или расширение интерфейса
class OtherThread implements Runnable {

    String name;

    public OtherThread(String name) {
        this.name = name;
    }

    // метод ничего не возвращается, не принимает аргументов
    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
