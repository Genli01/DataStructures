import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;

/**
 * Created by Gen on 6/4/17.
 */
public class ConsumerProducerUsingBlockingQueue {
    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    private static class ProducerTask implements Runnable {
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer Writes: " + i);
                    buffer.put(i++);
                    Thread.sleep((int)(Math.random() * 10000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ConsumerTask implements Runnable {
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\t\tConsumer Reads: " + buffer.take());
                    Thread.sleep((int)(Math.random() * 10000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
