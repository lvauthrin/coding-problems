import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

class DesignBoundedBlockingQueue {
  private final Semaphore queueLock;
  private final Semaphore dequeueLock;
  private final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

  public DesignBoundedBlockingQueue(int capacity) {
    queueLock = new Semaphore(capacity);
    dequeueLock = new Semaphore(0);
  }

  public void enqueue(int element) throws InterruptedException {
    queueLock.acquire();
    queue.offer(element);
    dequeueLock.release();
  }

  public int dequeue() throws InterruptedException {
    dequeueLock.acquire();
    var element = queue.poll();
    queueLock.release();
    return element;
  }

  public int size() {
    return queue.size();
  }

  public static void main(String[] args) throws InterruptedException {
    var boundedBlockingQueue = new DesignBoundedBlockingQueue(3);
    var random = new Random();
    var threads = new ArrayList<Thread>();

    // 3 producers
    for (int i = 0; i < 3; i++) {
      var thread = new Thread(() -> {
        var count = 0;
        while (count < 50) {
          try {
            Thread.sleep(10);
            var value = random.nextInt(10);
            boundedBlockingQueue.enqueue(value);
            System.out.println("Offering: " + value);
            count++;
          } catch (InterruptedException e) {
            e.printStackTrace();
            break;
          }
        }
      });

      threads.add(thread);
    }

    // 3 consumers
    for (int i = 0; i < 3; i++) {
      var thread = new Thread(() -> {
        var count = 0;
        while (count < 50) {
          try {
            Thread.sleep(10);
            int num = boundedBlockingQueue.dequeue();
            System.out.println("Polled: " + num);
            count++;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
      threads.add(thread);
    }

    for (var thread : threads)
      thread.start();

    for (var thread : threads) {
      thread.join();
      System.out.println(String.format("Thread '%s' completed", thread.getName()));
    }

    System.out.println("All done!");
  }
}
