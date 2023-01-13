import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return Collections.emptyList();
    }

    Arrays.sort(nums);

    final var answer = new ArrayList<List<Integer>>();

    for (int i = 0; i < nums.length - 2; i++) {
      final Set<String> seen = new HashSet<>();
      final var sum = nums[i];
      var left = i + 1;
      var right = nums.length - 1;

      while (left < right) {
        var twoSum = (nums[left] + nums[right]) * -1;
        var isNew = seen.add(String.format("%d:%d:%d", sum, nums[left], nums[right]));

        if (isNew && twoSum == sum) {
          answer.add(Arrays.asList(sum, nums[left], nums[right]));
          left++;
        } else if (twoSum <= sum) {
          left++;
        } else {
          right--;
        }
      }

      seen.clear();
    }

    return answer;
  }
}

// [-1,0,1,2,-1,-4], return triplets

// [-1,0,1,2,-1,-4], return triplets

// [-1,0,1,2,-1,-4], t = 0, seen = {0:1,2:2,-1:3,-4:4}, answ = [[-1,1],]
//
// [-4,-1,-1,0,1,2], t = -1, answ = [[-1,-1,2],[-1,0,1]], set = []
// c ^ ^
