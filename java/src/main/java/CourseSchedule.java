import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CourseSchedule {

  public boolean dfs(
      int course, Map<Integer, Set<Integer>> courses,
      Set<Integer> path,
      Set<Integer> seen) {
    if (seen.contains(course))
      return false;
    if (path.contains(course))
      return true;

    var chain = courses.get(course);

    if (chain == null)
      return false;

    path.add(course);

    for (int next : chain) {
      var cycle = dfs(next, courses, path, seen);

      if (cycle) {
        return true;
      }

    }

    path.remove(course);
    seen.add(course);

    return false;
  }

  public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
    // false -> if there's a cycle -
    // [2, 0] 0 -> 2
    // [1, 0] 0 -> 1
    //
    // [2, 0] 0 -> 2
    // [2, 1] 1 -> 2

    // Build graph (adjacency list)
    // For each graph, do DFS. Push as you go and pop as you come back. If "seen"
    // repeats then cycle
    // Return max count of depth. If depth == numCourses then true;

    // Build adjacency list
    // DFS through it keeping track of all courses seen.@interface
    // If all courses seen == numCourses then true
    if (prerequisites.length == 0)
      return true;

    var graph = new HashMap<Integer, Set<Integer>>();

    for (int[] prereq : prerequisites) {
      graph.computeIfAbsent(prereq[1], k -> new HashSet<Integer>());
      graph.get(prereq[1]).add(prereq[0]);
    }

    var path = new HashSet<Integer>();
    var seen = new HashSet<Integer>();

    for (int course : graph.keySet()) {
      var cycle = dfs(course, graph, path, seen);
      if (cycle)
        return false;
    }

    return true;
  }

  private static class GNode {
    public int incoming = 0;
    public List<Integer> outgoing = new ArrayList<>();
  }

  public boolean canFinishTopological(int numCourses, int[][] prerequisites) {
    // Build a graph structure that tracks incoming edges
    // [4,2][3,2][3,0][2,1]
    // 0 ------\
    // 1 -> 2 --> 3
    // \-> 4
    // [0 -> 0, [3] [1 -> 0, [2]] [2 -> 1, [3, 4]] [3 -> 2, []] [4 -> 1, []]
    // Iterate through no-deps ndoes and add them to global list queue
    // [0, 1]
    // Go through queue and for each dep, inc removed edges, dec inc count and add
    // to list if count is zero
    // [3, 4] rem = 4
    // [0 -> 0, [3] [1 -> 0, [2]] [2 -> 0, [3, 4]] [3 -> 0, []] [4 -> 0, []]
    // If the removed edge == total deps (which is prereq.length or numCourse?) then
    // all good
    var graph = new HashMap<Integer, GNode>();

    for (int[] prereq : prerequisites) {
      var second = graph.computeIfAbsent(prereq[0], k -> new GNode());
      var first = graph.computeIfAbsent(prereq[1], k -> new GNode());
      first.outgoing.add(prereq[0]);
      second.incoming++;
    }

    var queue = new LinkedList<Integer>();
    var removed = 0;

    for (var entry : graph.entrySet()) {
      if (entry.getValue().incoming == 0)
        queue.offer(entry.getKey());
    }

    while (!queue.isEmpty()) {
      var root = queue.pop();
      var node = graph.get(root);

      for (var child : node.outgoing) {
        var childNode = graph.get(child);
        childNode.incoming--;
        removed++;

        if (childNode.incoming == 0)
          queue.offer(child);
      }
    }

    return removed == prerequisites.length;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    return canFinishTopological(numCourses, prerequisites);
  }
}

/*
 * [ 1 2 3 4]
 * [0,1]
 */
