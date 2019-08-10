package multithreading.pool.synchronises;


import java.util.concurrent.Exchanger;

//
public class ExchangeExample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new MakeThread(exchanger).start();
        new UseThread(exchanger).start();


    }

}


class MakeThread extends Thread{

    String string;

    // указываем тип данных который будем передавать между потоками
    Exchanger<String> exchanger;

    public MakeThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        string = new String();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            string = "MakeThread make string " + i;
            try {
                // отдает строку, но забирает то, что было там до этой строки
                string = exchanger.exchange(string);
                System.out.println("Maker got string " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UseThread extends Thread {

    String string;
    Exchanger<String> exchanger;

    public UseThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            string = "UseThread make string " + i;
            try {
                // отдает строку, но забирает то, что было там до этой строки
                string = exchanger.exchange(string);
                System.out.println("User got string " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}