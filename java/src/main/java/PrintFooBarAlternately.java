import java.util.concurrent.Semaphore;

class PrintFooBarAlternately {
  private int n;
  private Semaphore a = new Semaphore(1);
  private Semaphore b = new Semaphore(1);

  public PrintFooBarAlternately(int n) {
    this.n = n;
    try {
      b.acquire(1);
    } catch (final InterruptedException e) {
      System.out.println(e);
    }
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {

      // printFoo.run() outputs "foo". Do not change or remove this line.
      a.acquire(1);
      printFoo.run();
      b.release(1);
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {

      // printBar.run() outputs "bar". Do not change or remove this line.
      b.acquire(1);
      printBar.run();
      a.release(1);
    }
  }
}
