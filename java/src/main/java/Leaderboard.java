import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
 * url: https://leetcode.com/discuss/interview-question/1511260/MongoDB-Phonescreen
 * List of Users with UserId and NameList
 * List of Logins with UserId and timestampReturn
 * Return leaderboard - Name and unique(login),

Example:
Users - [{1,"qw"},{2,"er"}]
Logins - [{1,1},{1,1},{1,3},{2,4},{2,5},{1,7}]
output (Print in descending order based on login attempts)
"qw" : 3
"er" : 2

User "qw" logged 4 times in total, unique attempts - 3. you can assume any input type (either 2d array or List).
*/
class Leaderboard {
  record User(int id, String name) {
  }

  record Login(int id, long timestamp) {
  }

  record LoginAttempts(String name, int count) {
  }

  public List<LoginAttempts> getLeader(final List<User> users, final List<Login> logins) {
    var userMap = users.stream().collect(Collectors.toMap(user -> user.id, user -> user.name));
    var attempts = new HashMap<Integer, HashSet<Long>>();

    for (var login : logins) {
      attempts.computeIfAbsent(login.id, k -> new HashSet<Long>());
      attempts.get(login.id).add(login.timestamp);
    }

    return attempts.entrySet()
        .stream()
        .map(entry -> new LoginAttempts(userMap.get(entry.getKey()), entry.getValue().size()))
        .sorted((a, b) -> b.count - a.count)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {

    var users = Arrays.asList(new User(1, "qw"), new User(2, "er"));
    var logins = Arrays.asList(
        new Login(1, 1l),
        new Login(1, 1l),
        new Login(1, 3l),
        new Login(2, 4l),
        new Login(2, 5l),
        new Login(1, 7l));

    var leaderboard = new Leaderboard();
    var expected = Arrays.asList(new LoginAttempts("qw", 3), new LoginAttempts("er", 2));
    System.out.println("Expected is : " + expected);
    System.out.println("Answer is : " + leaderboard.getLeader(users, logins));
  }
}
