import java.util.Arrays;

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        Arrays.fill(len,1);

        int max = 0;
        for(int i = 0; i < nums.length ; i ++){
            for(int j = 0 ; j < i ; j ++){
                if(nums[i] > nums[j]){
                    len[i] = Math.max(len[j]+1, len[i]);
                }
            }
            if(len[i] > max){
                max = len[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        solution300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}