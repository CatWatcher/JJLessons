package multithreading.pool.synchronises;


import java.util.concurrent.CountDownLatch;

// потоки будут ждать пока не произойдет событие
public class CountDownLatchExample {

    // когда событие случится 6 раз
    // когда счетчик будет равен 0
    // все потоки одновременно начнут работу
    private static final CountDownLatch START = new CountDownLatch(6);

    public static class Runner implements Runnable {

        long sleep;

        public Runner(long sleep) {
            this.sleep = sleep;
        }



        @Override
        public void run() {

            try {
                System.out.println("Runer "
                        + Thread.currentThread().getName() + " at start line");

                // этот метод уменьшает счетчик на единицу
                START.countDown();

                // блокирует данный поток пока счетчик не станет равен 0
                START.await();

                // когда счетчик станет 0
                // поток выполнет дальше действие (сон в данном случае)
                Thread.sleep(sleep);
                System.out.println("Runner " +
                        Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 3; i ++) {
            new Thread(new Runner(2000)).start();
        }

        while (START.getCount() > 3) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("На старт"); // событие, если это должно учитываться
        // то уменьшаем счетчик
        START.countDown();

        System.out.println("Внимание!");
        START.countDown();

        System.out.println("Марш!");
        START.countDown();

    }
}