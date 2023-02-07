import java.util.ArrayList;
import java.util.List;

class FindAllDisappearedNumbers {
  public void swaps(int[] nums, int curr) {
    while (curr != nums[curr - 1]) {
      var tmp = nums[curr - 1];
      nums[curr - 1] = curr;
      curr = tmp;
    }
  }

  public List<Integer> findDisappearedNumbersSwaps(int[] nums) {
    var curr = 0;

    while (curr < nums.length) {
      if (nums[curr] != curr + 1)
        swaps(nums, nums[curr]);
      curr++;
    }

    var ans = new ArrayList<Integer>();

    for (var i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1)
        ans.add(i + 1);
    }

    return ans;
  }

  public List<Integer> findDisappearedNumbersHash(int[] nums) {
    var sorted = new int[nums.length];

    for (var num : nums) {
      sorted[num - 1] = 1;
    }

    var ans = new ArrayList<Integer>();

    for (var i = 0; i < nums.length; i++) {
      if (sorted[i] == 0)
        ans.add(i + 1);
    }

    return ans;
  }

  public List<Integer> findDisappearedNumbers(int[] nums) {
    return findDisappearedNumbersSwaps(nums);
    // return findDisappearedNumbersHash(nums);
  }
}

/*
 * [4,3,2,7,8,2,3,1]
 * V
 * [1,2,3,4,8,2,7,8]
 * 
 */
