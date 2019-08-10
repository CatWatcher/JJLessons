package multithreading.concur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

// посмотреть методы очередей

//

public class ConcurrentExample {

    // потокобезопасные коллекции
    // блокирующие и неблокирующие очереди
    // пул потоков
    // альтернативы wait и notify и synchronised


    public static void main(String[] args) {

        // queues
        // blockable
        // являются общим ресурсом
        // эти очереди блокируют потоки
        // сами очереди не блокируются!!
        // можно указать размер
        // если не указывать - макс интежер
        LinkedBlockingDeque deque;
        LinkedBlockingQueue queue;

        // можно указать на какое время она будет блокировать поток
        LinkedTransferQueue transferQueue;

        // можно настроить сортировку элементов
        PriorityBlockingQueue blockingQueue;

        // нельзя изменить размер этой очереди
        // если флаг тру, то очередь будет устанавливать порядок
        // для читающих и пишущих потоков
        // т.е очередь будет управлять потоками
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(20, true);

        // не имеет размера
        // расчитана только на один элемент
        SynchronousQueue synchronousQueue;







        CopyOnWriteArraySet set;

        ConcurrentNavigableMap<String, Integer> map;

        // анадлолг триимап
        ConcurrentSkipListMap<String, Integer> map1;

        ConcurrentSkipListSet<String> set1;

        // методы мап
        // добавляет пару если нет одинаковых ключей
        map.putIfAbsent();

        // удалин если существует такая пара, вернет либо тру либо фолс
        map1.remove("qwe", 4);

        //заменит но вернет старое значение
        map.replace("qwe", 56);

        // перезапись, в ключ qwe вместо 4 пишем 6
        map.replace("qwe", 4, 6);

        // вместо ArrayList
        // поток может писать, а другой писать
        // коллекция не заблокируется
        //
//        CopyOnWriteArrayList
        // используется если мало записей происходит
        // больше для чтения

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Alice");
        list.add("Liza");
        list.add("Anne");
        list.add("Joan");

        new WriteThread(list).start();
        new ReadThread(list).start();

        //чтобы не добвлялись одинаковые данные
        list.addIfAbsent("try");
    }
}

class WriteThread extends Thread {
    private List<String> list;
    private ArrayList<String> data = new ArrayList<>();

    public WriteThread (List<String> list) {
        this.list = list;
        data.add("qwf");
        data.add("adc");
        data.add("qergf");
        data.add("arv");
        data.add("erv");
    }


    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (count == data.size() - 1) count = 0;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(data.get(count));
            count++;

            System.out.println("Write added");
        }
    }
}

class ReadThread extends Thread {
    private List<String> list;

    public ReadThread (List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            String res = "ReadThread res: ";

            for (String str : list) {
                // удаление данных
                if (str.equals("asd")) {
                    list.remove(str);
                }


                res += str + " ";
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // через итератор
//            Iterator<String> iterator = list.iterator();
//            while (iterator.hasNext()) {
//                String next = iterator.next();
//                res += next + " ";
//
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(res);
        }
    }
}