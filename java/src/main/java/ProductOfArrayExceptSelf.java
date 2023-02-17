public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    // [1 2 3 4]
    // [1 1 2 6]
    // [24 12 4 1]
    // [24 12 8 6]
    //
    // [-1, 1, 0,-3, 3]
    // [ 1, -1, -1, 0, 0]
    // [ 0, 0, -9, 3, 1]
    // [ 0, 0 9 0 0]

    var ans = new int[nums.length];

    ans[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      ans[i] = nums[i - 1] * ans[i - 1];
    }

    var total = 1;

    for (int i = nums.length - 1; i >= 0; i--) {
      ans[i] = total * ans[i];
      total *= nums[i];
    }

    return ans;
  }

}
