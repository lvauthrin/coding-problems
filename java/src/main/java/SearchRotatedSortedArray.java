class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
      if (nums.length == 0)
        return -1;
      
      int start = 0;
      int end = nums.length - 1;

      while (start <= end) {
        int mid = (start + end) / 2;

        if (nums[mid] == target) {
          return mid;
        } else if (nums[start] <= nums[mid]) {
          if (nums[start] <= target && target <= nums[mid]) {
            end = mid - 1;
          } else {
            start = mid + 1;
          }
        } else {
          if (nums[mid] <= target && target <= nums[end]) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
        }
      }

      return -1;
    }


    public static void main(final String args[]) {
      final SearchRotatedSortedArray solution = new SearchRotatedSortedArray();

      final int answer = solution.search(new int[] { 4,5,6,7,0,1,2}, 0);
      assert answer == 4;
      System.out.println("Answer was: " + answer);
    }
}

//  
// [4,5,6,7,0,1,2], target = 0
// [4,5,6,0,1,2,3], target = 0
// [0,1,2,4,5,6,7], target = 0
// [7,0,1,2,4,5,6], target = 0
//        s m e                      
// [4,5,6,7,0,1,2], target = 0
//                                   
