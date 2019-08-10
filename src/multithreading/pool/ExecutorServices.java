package multithreading.pool;

import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) {


        // просто передаем задачу, пул сам запускает старт

        // фиксированное кол-во потоков
        // не зависимо от кол-ва задач
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        // завершение
        // после этого метода невозможно использовать пул
        // будет раннбл эксепшн
        fixedPool.shutdown();


        // пул из одного потока
        ExecutorService singleThread = Executors.newSingleThreadExecutor();

        // метод экзекьют ничего не возвращает
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));

        singleThread.shutdown();


        // тут потоки создаются исходя из задач, возложенных на пул
        // если не хватает потоков, то создаются новые
        // сколько посчитает нужным столько и создаст
        ExecutorService cachedThread = Executors.newCachedThreadPool();

        // метод субмит возвращает объект фьюча
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.shutdown();


        // отложенное выполнение
        // если нужны паузы между выполнениям
        // или нужно отложить выполнение задачи
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // передаем задачу, потом сколько ждать, потом в каких еденицах измерения
        Future future = scheduledExecutorService.schedule(new CallableTask("scheduled"),
                5, TimeUnit.SECONDS);

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();

        // завершает немедленно
        // .shutdownNow();

        // выполнение каждые промежутки времени
        // н (каждые 5 секунд)
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        // передаем задачу, потом через сколько начать выполнение
        // и через сколько будут повторения
        executorService.scheduleAtFixedRate(new RunnableTask("run every five second "),
                0, 5, TimeUnit.SECONDS);
        executorService.shutdown();


        //
        ScheduledExecutorService everySecond = Executors.newSingleThreadScheduledExecutor();
        everySecond.scheduleWithFixedDelay(new RunnableTask("everySecond"),
                0, 3, TimeUnit.SECONDS);
    }
}


class CallableTask implements Callable<Integer> {

    String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread: " + Thread.currentThread().
                getName() + "from pool " + name);
        return 2 + 3;
    }
}

class RunnableTask implements Runnable {
    String name;

    public RunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + "from pool " + name);
    }
}
