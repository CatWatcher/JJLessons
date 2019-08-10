package multithreading.Pizza;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.concurrent.ArrayBlockingQueue;

// три потока клиент официант и повар
// клиент делает заказы
// три очереди - новые заказы, заказы для кухни и готовые
// заказ - то что получаем из очереди и добавляем в очередь
// официант берет заказ из очереди 1 и добавляет его в очередь 2
// повар из кухни в готовые
// клиент забирает готовый заказ из последней очереди
//
public class Pizza {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> newOrder = new ArrayBlockingQueue<>(3, true);
        ArrayBlockingQueue<Order> forCook = new ArrayBlockingQueue<>(3, true);
        ArrayBlockingQueue<Order> done = new ArrayBlockingQueue<>(3, true);

        Waiter waiter = new Waiter(newOrder, forCook);
        Waiter waiter1 = new Waiter(newOrder, forCook);
        Waiter waiter2 = new Waiter(newOrder, forCook);
        waiter.start();
        waiter1.start();
        waiter2.start();

        Cook cook = new Cook(forCook, done);
        cook.start();

        Order meat = new Order("meat");
        Order cheese = new Order("cheese");
        Order veg = new Order("veg");
        Order goBaoJo = new Order("goBaoJo");


        Client client = new Client(newOrder, done);
        Client client1 = new Client(newOrder, done);
        Client client2 = new Client(newOrder, done);

        // делаем заказы
        client.makeOrder(meat);
        client.start();
        client1.start();

        client1.makeOrder(veg);
        client2.start();

        client2.makeOrder(cheese);
        client.makeOrder(goBaoJo);


    }
}


class Client extends Thread {
    private ArrayBlockingQueue<Order> newOrder;
    private ArrayBlockingQueue<Order> done;

    public Client(ArrayBlockingQueue<Order> newOrder, ArrayBlockingQueue<Order> done) {
        this.newOrder = newOrder;
        this.done = done;
    }

    public void makeOrder (Order order) {
        try {
            newOrder.put(order);
            System.out.println("Client make an order");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Client got an order" + done.take().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Waiter extends Thread{
    private ArrayBlockingQueue<Order> newOrder;
    private ArrayBlockingQueue<Order> forCook;

    public Waiter(ArrayBlockingQueue<Order> newOrder, ArrayBlockingQueue<Order> forCook) {
        this.newOrder = newOrder;
        this.forCook = forCook;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = newOrder.take();
                System.out.println("Waiter take an order" + order.getName());
                forCook.put(order);
                System.out.println("Waiter give order: " + order.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

class Cook extends Thread {
    private ArrayBlockingQueue<Order> forCook;
    private ArrayBlockingQueue<Order> done;

    public Cook(ArrayBlockingQueue<Order> forCook, ArrayBlockingQueue<Order> done) {
        this.forCook = forCook;
        this.done = done;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = forCook.take();
                System.out.println("order in process " + order.getName());
                Thread.sleep(20000);
                done.put(order);
                System.out.println("Order is ready " + order.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class Order {
    String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
