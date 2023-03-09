import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
  volatile int tokens;
  final ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
  final ScheduledFuture<?> incBucketFuture;

  public TokenBucketRateLimiter(int tokens) {
    this.tokens = tokens;
    this.incBucketFuture = service.scheduleWithFixedDelay(() -> {
      TokenBucketRateLimiter.this.tokens += 1;
      System.out.println("Tokens: " + TokenBucketRateLimiter.this.tokens);
    }, 50, 50, TimeUnit.MILLISECONDS);
  }

  public boolean allowRequest(long ts) {
    if (tokens == 0)
      return false;
    tokens -= 1;
    return true;
  }

  public void shutdown() throws InterruptedException {
    this.incBucketFuture.cancel(true);
    // TODO: Determine if all of these are necessary
    this.service.awaitTermination(500l, TimeUnit.MILLISECONDS);
    this.service.shutdownNow();
  }

  public static void main(String[] args) throws InterruptedException {
    var rlm = new TokenBucketRateLimiter(5);

    for (Map.Entry<Long, Boolean> req : Arrays.asList(
        Map.entry(0l, true),
        Map.entry(5l, true),
        Map.entry(10l, true),
        Map.entry(15l, true),
        Map.entry(20l, true),
        Map.entry(25l, false),
        Map.entry(30l, false),
        Map.entry(35l, false),
        Map.entry(40l, false),
        Map.entry(45l, false),
        Map.entry(50l, true),
        Map.entry(55l, false)
    )) {
      if (rlm.allowRequest(req.getKey()) != req.getValue())
        System.out.println(String.format("Failure: %s was %s", req.getKey(), req.getValue()));
      Thread.sleep(5l);
    }
    rlm.shutdown();
    Thread.sleep(500l);
    System.out.println("Done!");
  }
}
