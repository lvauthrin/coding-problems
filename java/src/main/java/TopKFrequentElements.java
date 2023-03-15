import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    /*
     * Approach 1:
     * Go through each item, update count in hashmap. Then sort hashmap entries by
     * value desc. Take the first k items
     * O(n) + O(n log(n))
     * 1 => 3
     * 2 => 2 ==> (1,3), (2, 2), (3, 1) => (1, 2)
     * 3 => 1
     * 
     * Approach 2:
     * Go through each item, update count in hashmap. Go through each item and store
     * in min heap of size k. Return values in heap.
     * O(n) + O(n log(k))
     * 1 => 3
     * 2 => 2 ==> (1,3) ==> (2, 2), (1, 3) ==> (2, 2), (1, 3) = => (2, 1)
     * 3 => 1
     * 
     * Approach 3:
     * Go through each item, update count in hashmap. Create a frequency map of
     * array size, set the freq for each item. Return highest values.
     * O(n)
     * 1 => 3
     * 2 => 2 ==> [3, 2, 1, 0, 0, 0] => (1, 2)
     * 3 => 1
     */

    var counts = new HashMap<Integer, Integer>();

    for (var num : nums) {
      counts.compute(num, (i, v) -> v == null ? 1 : v + 1);
    }

    var freqs = IntStream.range(0, nums.length + 1).boxed().map(i -> new ArrayList<Integer>())
        .collect(Collectors.toList());

    for (var entry : counts.entrySet()) {
      freqs.get(entry.getValue()).add(entry.getKey());
    }

    var topK = new int[k];
    var i = 0;
    var j = freqs.size() - 1;

    while (j > 0 && i < k) {
      for (var num : freqs.get(j--)) {
        topK[i++] = num;
        if (i == k)
          break;
      }
    }

    return topK;
  }
}
