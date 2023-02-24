import java.util.Arrays;
import java.util.Random;

class Solution462 {
    Random random = new Random();

    public int minMoves2(int[] nums) {
        int target = nums.length /2;

        int index = quickSelect(nums , 0 , nums.length-1 , target);

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - nums[index]);
        }

        return ans;
    }

    private int quickSelect(int[] nums, int l, int r, int target) {
        int randomIndex = random.nextInt(r-l +1) + l;

        int trueIndex = partition(nums , l , r , randomIndex);

        if (trueIndex < target){
            l = trueIndex +1;
            return quickSelect(nums , l , r , target);
        } else if (trueIndex > target) {
            r = trueIndex -1;
            return quickSelect(nums , l , r , target);
        }else {
            return trueIndex;
        }
    }

    private int partition(int[] nums, int l , int r , int randomIndex){
        int trueIndex = l;
        int flag = nums[randomIndex];
        swap(nums, r , randomIndex);

        for (int i = l; i <= r-1; i++) {
            if (nums[i] < flag){
                swap(nums , trueIndex , i);
                trueIndex ++;
            }
        }

        swap(nums , trueIndex , r);

        return trueIndex;
    }

    private void swap(int[] nums , int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}