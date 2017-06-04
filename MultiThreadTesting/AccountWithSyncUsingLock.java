import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Gen on 6/4/17.
 */
public class AccountWithSyncUsingLock {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        //Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddPennyTask());
        }
        executor.shutdown();
        //wait until all tasks are finished
        while (!executor.isTerminated()) {
        }
        System.out.println("What is balance?" + account.getBalance());
    }
    private static class AddPennyTask implements Runnable {
        public void run() {
            account.deposit(1);
        }
    }
    private static class Account{
        private static Lock lock = new ReentrantLock(); //create a lock
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock(); //acquire the lock

            try {
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }

}
