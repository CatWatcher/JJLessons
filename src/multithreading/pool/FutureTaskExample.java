package multithreading.pool;

import java.util.concurrent.*;

public class FutureTaskExample {

    public static void main(String[] args) {
        Callable<UserInfo> callable1 = new CreateUserTask(2000);
        Callable<UserInfo> callable2 = new CreateUserTask(3000);


        // передаем в конструктор на выполнение объект коллбл или раннбл
        FutureTask<UserInfo> futureTask1 = new FutureTask<>(callable1);
        FutureTask<UserInfo> futureTask2 = new FutureTask<>(callable2);

        // создаем пул потоков
        ExecutorService service = Executors.newFixedThreadPool(2);
        // метод экзекьют ничего не возвращает, только выполняет задачу в скобках
        service.execute(futureTask1);
        service.execute(futureTask2);

        while (true) {
            if (futureTask1.isDone() && futureTask2.isDone()) {
                System.out.println("Tasks are executed");
                // отключаем пул потоков.. аккуратно!
                // ждет пока задачи зхавершаться
                service.shutdown();
                return;
            }

            if (futureTask1.isDone()) {
                try {
                    // в данном случае футуретаск вернет объекты юзер инфо
                    System.out.println("task result: " + futureTask1.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Waiting futureTask2...");

            // тут можно указать в чем будет измеряться время
            UserInfo userInfo = null;
            try {
                // тайм аут используется если результат не нужен прямо сейчас
                // или не нужен вообще
                // в обычном случае просто проверяем на ис дон
                //
                userInfo = futureTask2.get(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            if (userInfo != null) {
                System.out.println("future2 result" + futureTask2.get());
            }
        }


    }
}



class UserInfo {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}

class CreateUserTask implements Callable<UserInfo> {

    long sleepTime;

    public CreateUserTask(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public UserInfo call() throws Exception {
        Thread.sleep(sleepTime);

        UserInfo userInfo = new UserInfo();
        userInfo.setName(Thread.currentThread().getName());

        return userInfo;
    }
}