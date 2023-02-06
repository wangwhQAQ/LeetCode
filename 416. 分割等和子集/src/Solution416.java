class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1){
            return false;
        }

        boolean[][] dp = new boolean[nums.length+1][sum/2 + 1];
        if (nums[0] > sum/2){
            return false;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if (j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                } else if (j == nums[i]) {
                    dp[i][j] = true;
                } else if (nums[i] > sum / 2) {
                    return false;
                } else {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (dp[i][sum/2]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution416 s = new Solution416();
        s.canPartition(new int[]{2,2,3,5});
    }
}