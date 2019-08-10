package multithreading.synchronize;

public class Library {

    public static void main(String[] args) {
        BookStorage storage = new BookStorage();
        new Thread(new PutThread(storage)).start();
        new Thread(new GetThread(storage)).start();
    }
}

class BookStorage {
    // общий ресурс
    // один поток увеличивает,
    // второй увеличивает
    int bookCount = 0;

    public synchronized void putBook () throws InterruptedException {
        System.out.println("putBook starting");
        while ( bookCount >= 5) {
            wait();
            System.out.println("putBook waiting");
        }
        bookCount++;
        System.out.println("bookCount put + " + bookCount);
        System.out.println("Put finished");
    }

    public synchronized  void getBook () throws InterruptedException {
        System.out.println("getBook - start working");
        while (bookCount < 1) {
            // усыпление потока
            // ждет пока его не запустит другой поток
            // не означает что поток будет спать пока не разбудят,
            // но иногда он пробуждается самостоятельно и снова проверяется условие
            //
            wait();
            System.out.println("getBook waiting");
        }

        bookCount--;
        System.out.println("bookCount get + " + bookCount);

        // будит случайный поток
        // notifyAll() - будит все потоки
        notify();
    }
}



class PutThread implements Runnable {

    BookStorage storage;

    public PutThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                storage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetThread implements Runnable{
    BookStorage storage;

    public GetThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}