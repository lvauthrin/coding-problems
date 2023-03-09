import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DesignBoundedBlockingQueueWithLocks {
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private final Lock writeLock = lock.writeLock();
  private final Lock readLock = lock.readLock();
  private final Condition queueFull = writeLock.newCondition();
  private final Condition queueEmpty = writeLock.newCondition();
  private final LinkedList<Integer> queue = new LinkedList<>();
  private final int capacity;
  private final AtomicInteger counter = new AtomicInteger(0);

  public DesignBoundedBlockingQueueWithLocks(int capacity) {
    this.capacity = capacity;
  }

  public void enqueue(int element) throws InterruptedException {
    writeLock.lock();

    try {
      counter.incrementAndGet();
      while (queue.size() == capacity)
        queueFull.await();
      System.out.println(counter.decrementAndGet());

      queue.offer(element);
      queueEmpty.signal();
    } finally {
      writeLock.unlock();
    }
  }

  public int dequeue() throws InterruptedException {
    writeLock.lock();

    try {
      while (queue.size() == 0)
        queueEmpty.await();

      var element = queue.poll();
      queueEmpty.signal();
      return element;
    } finally {
      writeLock.unlock();
    }
  }

  public int size() {
    readLock.lock();

    try {
      return queue.size();
    } finally {
      readLock.unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    var boundedBlockingQueue = new DesignBoundedBlockingQueueWithLocks(3);
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
            // System.out.println("Offering: " + value);
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
            boundedBlockingQueue.dequeue();
            // System.out.println("Polled: " + num);
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
