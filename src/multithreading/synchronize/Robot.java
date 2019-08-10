package multithreading.synchronize;


// Thread.yield() - отдает управление другому потоку
// а сам перемещается в конец очереди
public class Robot {

    // потоки записывают переменную в кэш и работают с кэш
    // из-за этого значение не всегда актуально
    // волатайл - для потоков запрещает кэшировать переменную
    // т.е потоки обращаются напрямую к переменной
    // значения переменной всегда будут актуальными
    // лучше не злоупотреблять, т.к это замедляет работу программы
    volatile boolean current = true;

    Leg left = new Leg("eft", false);
    Leg right = new Leg("right", true);

    class Leg implements Runnable {
        String name;
        boolean leg;

        public Leg(String name, boolean leg) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                if (leg == true) {
                    step();
                    current = !leg;
                    Thread.yield();
                }
            }
        }

        void step () {
            System.out.println(name);
        }
    }

    void start () {
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {

    }
}
