import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DesignTwitter {
  record Tweet(int tweetId, int ts) {
  }

  Map<Integer, Set<Integer>> followerMap = new HashMap<>();
  Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();
  int ts = 0;

  public DesignTwitter() {

  }

  /*
   * Alternate approach is to keep a sorted list of tweets for all users
   * Whenever a user tweets, add it to their list O(log m) and their follower's
   * lists O(log m) (m = # of tweets)
   * This would make it O(k * log m) where k is the number of followers
   * Fetching a news feed at that point is O(1)
   */
  public void postTweet(int userId, int tweetId) {
    // O(1)
    tweets.computeIfAbsent(userId, k -> new LinkedList<Tweet>());
    tweets.get(userId).addFirst(new Tweet(tweetId, ts++));
  }

  public List<Integer> getNewsFeed(int userId) {
    // O(nm * log(k))
    var followees = new LinkedList<>(followerMap.getOrDefault(userId, new HashSet<>()));
    followees.addFirst(userId);
    var heap = new PriorityQueue<Tweet>(11, (a, b) -> a.ts - b.ts);

    for (var followee : followees) {
      for (var tweet : tweets.getOrDefault(followee, new LinkedList<>())) {
        heap.offer(tweet);
        if (heap.size() > 10)
          heap.poll();
      }
    }

    var ans = Stream.generate(heap::poll).takeWhile(Objects::nonNull).map(t -> t.tweetId).collect(Collectors.toList());
    Collections.reverse(ans);
    return ans;
  }

  public void follow(int followerId, int followeeId) {
    // O(1)
    followerMap.computeIfAbsent(followerId, k -> new HashSet<>());
    followerMap.get(followerId).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    // O(1)
    followerMap.getOrDefault(followerId, Collections.emptySet()).remove(followeeId);
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
