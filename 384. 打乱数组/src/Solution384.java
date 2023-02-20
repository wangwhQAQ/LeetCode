import java.util.Random;

class Solution384 {
    int[] nums;
    int[] original;

    public Solution384(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums , 0 , this.original , 0 , nums.length);
    }

    public int[] reset() {
        System.arraycopy(this.original , 0 , this.nums , 0 , nums.length);
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < this.nums.length; i++) {
            int temp = nums[i];
            int j = i + random.nextInt(nums.length - i);
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */