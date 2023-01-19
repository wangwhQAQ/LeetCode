class Solution42 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right){
            if (nums[left] == nums[right] ){
                left++;
                continue;
            }
            if (nums[left] < nums[right]){
                return nums[left];
            }
            int mid = (left+right)/2;
            if (nums[left] <= nums[mid]){
                left = mid;
            }else {
                right = mid;
            }
            if (right-left == 1){
                return Math.min(nums[left], nums[right]);
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        solution42.findMin(new int[]{3,1,3,3});
    }
}