package multithreading.pool;

import com.ifmo.lesson4.animals.Run;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {

        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();


        // к такому пулу мы можем указать настройки
        //
        // сначала основное кол-во потоков
        // максимальное кол-во потоков
        // сколько потоки, на которые не хватило задач будут простаивать
        // последний аргумент - очередь для задач, которые будут выполнять потоки
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1 , 10,
                2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3));

        queue.add(new Task());
        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task2());
        queue.add(new Task());
        queue.add(new Task());
        queue.add(new Task());
        queue.add(new Task3());
        queue.add(new Task());
        queue.add(new Task());
        queue.add(new Task3());
        queue.add(new Task3());
        queue.add(new Task3());
        for (Runnable runnable : queue) {
            pool.execute(runnable);
        }
        pool.shutdown();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task: " + Thread.currentThread().getName());
    }
}

class Task2 implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2: " + Thread.currentThread().getName());
    }
}

class Task3 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task3: " + Thread.currentThread().getName());
    }
}