import java.util.Arrays;

class Solution347 {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
//        Arrays.fill(dp , new int[]{1, 1});
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i][1] = Math.max(dp[j][0] + 1 , dp[i][1]);
                } else if (nums[j] > nums[i]) {
                    dp[i][0] = Math.max(dp[j][1] + 1 , dp[i][0]);
                }
            }
            max = Math.max(dp[i][0] , max);
            max = Math.max(dp[i][1] , max);
        }

        return max;
    }
}