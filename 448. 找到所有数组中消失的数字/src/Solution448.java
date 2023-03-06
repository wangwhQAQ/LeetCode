import java.util.ArrayList;
import java.util.List;

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[nums[i]] += n;
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] < n){
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}