package multithreading.synchronize.bank;

import com.ifmo.gym.AccessMode;

public class Transaction implements Runnable {
    // с какого счета
    private Account src;
    // на какой счет
    private Account dst;
    private int money;

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        // перевод с срц на дст

        if (src.getId() < dst.getId()) {
            synchronized (src) {
                synchronized (dst) {

                }
            }
        } else {
            synchronized (dst) {
                synchronized (src) {

                }
            }
        }
    }
}
