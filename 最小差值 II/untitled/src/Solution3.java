import java.util.Arrays;

class Solution3 {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = nums[0] + k, R = nums[len - 1] - k;
        int ans = nums[len - 1] - nums[0];
        for (int i = 1; i < len; i++) {
            int r = nums[i - 1] + k;
            int L = nums[i] - k;
            int cur = Math.max(R, r) - Math.min(L, l);
            ans = Math.min(ans, cur);
        }
        return ans;
    }


    public int smallestRangeII2(int[] nums, int k) {
        int index1,index2 = nums.length;
        int min = nums[nums.length-1] - nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) < min){
                    index1 = i;
                    index2 = j;
                    min = Math.abs(nums[i] - nums[j]);
                }
                if (Math.abs(nums[i] - nums[j]) -2*k < min){
                    index1 = i;
                    index2 = j;
                    min = Math.abs(nums[i] - nums[j] - 2*k);
                }
            }
        }
        return min;
    }


    public static void main(String[] args){
        int[] nums = {1,4,6,4};
        Solution3 s3 = new Solution3();
        s3.smallestRangeII(nums,3);
    }
}