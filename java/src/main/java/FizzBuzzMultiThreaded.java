import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzzMultiThreaded {
  private volatile boolean debug = false;
  private int n;
  private AtomicInteger a = new AtomicInteger(1);
  private Semaphore fizz = new Semaphore(0);
  private Semaphore buzz = new Semaphore(0);
  private Semaphore fizzbuzz = new Semaphore(0);
  private Semaphore number = new Semaphore(1);
  private int fizzx, buzzx, fizzbuzzx, numx = 0;

  public FizzBuzzMultiThreaded(int n) {
    this.n = n;
    this.fizzbuzzx = n / 15;
    this.fizzx = n / 3 - fizzbuzzx;
    this.buzzx = n / 5 - fizzbuzzx;
    this.numx = n - fizzx - buzzx - fizzbuzzx;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    while (fizzx-- > 0) {
      fizz.acquire();
      printFizz.run();
      helper();
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (buzzx-- > 0) {
      buzz.acquire();
      printBuzz.run();
      helper();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (fizzbuzzx-- > 0) {
      fizzbuzz.acquire();
      printFizzBuzz.run();
      helper();
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (numx-- > 0) {
      number.acquire();
      printNumber.accept(a.get());
      helper();
    }
  }

  private void print() {
    if (debug) {
      System.out.println(
          String.format(
              "%s [%s, %s, %s, %s] [%s, %s, %s, %s]",
              a.get(),
              fizz.availablePermits(),
              buzz.availablePermits(),
              fizzbuzz.availablePermits(),
              number.availablePermits(),
              fizzx,
              buzzx,
              fizzbuzzx,
              numx));
    }
  }

  private void helper() {
    int v = a.incrementAndGet();

    if (v % 3 == 0 && v % 5 == 0) {
      fizzbuzz.release();
    } else if (v % 3 == 0) {
      fizz.release();
    } else if (v % 5 == 0) {
      buzz.release();
    } else {
      number.release();
    }

    print();
  }
}
