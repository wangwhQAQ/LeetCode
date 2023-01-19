class Solution41 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        if (left == right){
            if (target == nums[left]){
                return true;
            }else {
                return false;
            }
        }
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[right] && nums[mid] == nums[right]){
                left++;
                right --;
            } else if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]){
                    right = mid-1;
                }else {
                    left = mid;
                }
            } else if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }else {
                if (target == nums[left]){
                    return true;
                }else {
                    left = mid+1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution41 s = new Solution41();
        s.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1} , 2);
    }

}