import java.util.concurrent.Semaphore;

class PrintInOrder {
  private final Semaphore second = new Semaphore(1);
  private final Semaphore third = new Semaphore(1);

  public PrintInOrder() {
    try {
      second.acquire(1);
      third.acquire(1);
    } catch (final InterruptedException e) {
      System.out.println(e);
    }
  }

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    second.release(1);
  }

  public void second(Runnable printSecond) throws InterruptedException {

    // printSecond.run() outputs "second". Do not change or remove this line.
    try {
      second.acquire(1);
      printSecond.run();
      third.release(1);
    } catch (Exception e) {
      System.out.println(e);
      throw e;
    }
  }

  public void third(Runnable printThird) throws InterruptedException {

    // printThird.run() outputs "third". Do not change or remove this line.
    try {
      third.acquire(1);
      printThird.run();
    } catch (Exception e) {
      System.out.println(e);
      throw e;
    }
  }

  public static void main(final String[] args) throws InterruptedException {
    final var foo = new PrintInOrder();
    // TODO: FIgure out how to run this with threads
  }
}
