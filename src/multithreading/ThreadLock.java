package multithreading;

// каждый поток заблокировал по объекту
// в итоге они так никогда не разблокируются
// программа никогда не завершится
// ресурсы тратятся на ожидание

// чтобы такого не было, последовательность работы должна быть одинаковой
// тогда все будет ок
// нужно следить за очередностью блокировки объектов
public class ThreadLock {
    public static void main(String[] args) {
        Object object = new Object();
        Object object1 = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start");
                synchronized (object) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread locked object");

                    synchronized (object1) {
                        System.out.println("thread locked object1");
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 start");
                synchronized (object1) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread1 locked object1");

                    synchronized (object) {
                        System.out.println("thread1 locked object");
                    }
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
