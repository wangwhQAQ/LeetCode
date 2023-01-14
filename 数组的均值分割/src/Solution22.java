import java.util.Arrays;

class Solution22 {
    public boolean splitArraySameAverage(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        if (sum%2 ==1){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]* n - sum;
        }
        return false;

    }

    public static void main(String[] args) {
        Solution22 s = new Solution22();
    }
}