class Solution40 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int index = -1;
        while(left <= right){
            int mid = (left+right) /2;
            if (target < nums[mid]){
                right = mid-1;
            } else if (target > nums[mid]) {
                left = mid+1;
            }else {
                index = mid;
                break;
            }
        }

        if (index == -1){
            return new int[]{-1,-1};
        }
        int leftIndex = index, rightIndex = index;
        while (leftIndex >=0 && target == nums[leftIndex] ){
            leftIndex--;
        }
        while (rightIndex < nums.length && target == nums[rightIndex]){
            rightIndex++;
        }
        return new int[]{leftIndex+1, rightIndex-1};
    }
}