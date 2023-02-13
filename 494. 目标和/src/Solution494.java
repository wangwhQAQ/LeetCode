import java.util.Arrays;

class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum){
            return 0;
        }
        int[][] dp = new int[nums.length+1][2*sum+1];

        int offset = sum;
        dp[1][offset+nums[0]] ++;
        dp[1][offset-nums[0]] ++;

        int currentSum = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            currentSum += nums[i-1];
            for (int j = -currentSum; j < currentSum+1; j++) {
                if (offset + j +nums[i-1] >= 2*sum +1 ){
                    dp[i][offset + j] = dp[i-1][offset + j -nums[i-1]];
                }else if (offset + j - nums[i-1] < 0){
                    dp[i][offset + j] = dp[i-1][offset + j + nums[i-1]];
                }else {
                    dp[i][offset + j] = dp[i-1][offset + j -nums[i-1]] + dp[i-1][offset + j + nums[i-1]];
                }

            }
        }



        return dp[nums.length][offset + target];
    }

    public static void main(String[] args) {
        Solution494 s = new Solution494();
        s.findTargetSumWays(new int[]{7,9,3,8,0,2,4,8,3,9} , 0);
    }
}