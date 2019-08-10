package multithreading.pool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        // можно создать пул потоков
        // создаем очередь из 10 потоков
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // описание потока
        Callable<Article> articleThread = new ThreadTask();

        // сюда складываем полученные значения
        ArrayList<Future<Article>> list = new ArrayList<>();

        // наши 10 потоков будут выполнять задачу 15 раз
        for (int i = 0; i < 15; i++) {
            // тут связываем пул потоков с нашей задачей
            // т.е в артиклсред мы описываем задачу
            // которую должен выполнить поток
            Future <Article> future = executorService.submit(articleThread);
            list.add(future);
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());
        }

        for (Future<Article> future : list) {
            try {
                System.out.println("Result: " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}

class Article {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                '}';
    }
}

// аналог раннбл
// получение возвращаемого потоком значения
// если нужно получать результат
// в остальных случаях юзаем раннбл

// позволяет вернуть из потока какое-то значение
// в дженерике тип данных, который будет возвращаться
// переопределяем метод колл
class ThreadTask implements Callable<Article> {

    @Override
    public Article call() throws Exception {
        Thread.sleep(10000);
        Article article = new Article();
        // в названии статьи будет имя потока, еоторый её создал
        article.setTitle(Thread.currentThread().getName());
        return article;
    }
}