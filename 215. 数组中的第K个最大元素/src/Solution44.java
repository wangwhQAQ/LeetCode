import java.util.Random;

class Solution44 {
    Random random = new Random();

    public int quickSelect(int[] a, int left, int right, int target){
        int pivotIndex = left + random.nextInt(right-left);
        int trueIndex = partition(a, left, right, pivotIndex);

        if (trueIndex > target){
            return quickSelect(a, left, trueIndex, target);
        } else if (trueIndex < target) {
            return quickSelect(a, trueIndex+1, right, target);
        }else {
            return a[trueIndex];
        }
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index2];
        nums[index2] = nums[index1];
        nums[index1] = temp;
    }

    public int partition(int[] a, int left, int right, int pivotIndex){
        if (left == right-1){
            return left;
        }
        swap(a, pivotIndex, right-1);
        int temp = pivotIndex;

        int defaultIndex = left;
        for (int i = left; i < right-1; i++) {
            if (a[i] < a[right-1]){
                swap(a, i, defaultIndex);
                defaultIndex++;
            }
        }

        swap(a, defaultIndex, right-1);

        return defaultIndex;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length, nums.length-k);
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();

        solution44.findKthLargest(new int[]{99,99},1);
    }
}