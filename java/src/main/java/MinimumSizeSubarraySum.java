class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        var ans = Integer.MAX_VALUE;
        var s = 0;
        var cur = 0;

        for (var e = 0; e < nums.length; e++) {
            cur += nums[e];

            while (cur >= target) {
                ans = Math.min(ans, e - s + 1);
                cur -= nums[s++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

