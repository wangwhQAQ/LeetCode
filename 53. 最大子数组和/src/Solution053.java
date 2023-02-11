import java.util.Arrays;

class Solution053 {
    public int maxSubArray(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        int max = ans[0];

        for (int i = 1; i < nums.length; i++) {
            if (ans[i-1] < 0){
                ans[i] = nums[i];
            }else {
                ans[i] = ans[i-1] + nums[i];
            }

            max = Math.max(ans[i] , max);
        }

        return max;
    }
}