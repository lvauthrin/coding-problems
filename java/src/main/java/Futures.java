import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
 * Demonstration of Java Future capabilities
 */
public class Futures {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    /*
     * Scala:
     * val completedFuture = Future.successful(sys.nanoTime())
     * completedFuture.foreach(println)
     */
    var completedFuture = CompletableFuture.completedFuture(System.nanoTime());
    completedFuture.thenAccept(System.out::println);

    /*
     * // @formatter:off
     * Scala:
     *
     * completedFuture
     *   .map(sys.nanoTime() - _)
     *   .foreach(println)
     *
     * // @formatter:on
     */
    completedFuture
        .thenApply(start -> System.nanoTime() - start)
        .thenAccept(System.out::println);

    /*
     * // @formatter:off
     * Scala:
     *
     * completedFuture
     *   .flatmap(v -> Future.successful(sys.nanoTime() - v))
     *   .foreach(println)
     *
     * // @formatter:on
     */
    completedFuture
        .thenComposeAsync(v -> CompletableFuture.completedFuture(v + 1))
        .thenAcceptAsync(System.out::println);

    /*
     * // @formatter:off
     * Scala:
     *
     * completedFuture
     *   .flatmap(v -> Future.failed(new Exception("oops!")))
     *   .transform(v => { println(v); return 1; } , e => { println(e); return 1; })
     *
     * // @formatter:on
     */
    completedFuture
        .thenCompose(v -> CompletableFuture.<Integer>failedFuture(new Exception("oops!")))
        .thenApply(v -> v + 1)
        .handle((t, e) -> {
          if (t != null)
            System.out.println(t);
          else
            System.out.println(e);
          return 1;
        })
        .thenAccept(System.out::println);

  }
}
