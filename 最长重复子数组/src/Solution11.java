import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution11 {
    int base = 102;
    long mod = 1000000009;
    public int findLength(int[] nums1, int[] nums2) {
        int left = 0, right = Math.min(nums1.length,nums2.length);


        while(right > left ){
            int len = Math.max((right - left)/2, 1);
            if (check(nums1, nums2, left+len)){
                left = left+len;
            }else {
                right = left+len-1;
            }
        }

        return left;
    }

    public boolean check(int[] nums1, int[] nums2, int len){
        Set<Long> nums1HashSet = new HashSet<>();
        long rabin1 = rabinKarp(nums1, 0, len);
        nums1HashSet.add(rabin1);
        for (int i = 1; i <= nums1.length - len; i++) {
            long rabins = moveSlidingWindow(rabin1, nums1[i+len-1], nums1[i-1],len);
            rabin1 = rabins;
            nums1HashSet.add(rabins);
        }

        long nums2rabin1 = rabinKarp(nums2, 0, len);
        if (nums1HashSet.contains(nums2rabin1)){
            return true;
        }
        for (int i = 1; i <= nums2.length - len; i++){
            long rabins = moveSlidingWindow(nums2rabin1, nums2[i+len-1], nums2[i-1], len);
            nums2rabin1 = rabins;
            if (nums1HashSet.contains(rabins)){
                return true;
            }
        }

        return false;
    }

    public long rabinKarp(int[] nums, int index, int len){
        long ans = 0L;
        for (int i = 0 ; i < len ; i ++){
            ans = (ans * base + nums[index+i]) % mod;
        }
        return ans;
    }

    public long moveSlidingWindow(long ans, int add, int remove, int len){
        ans = ((ans + mod - remove*pow(base,len)% mod)*base + add)  % mod;
        return ans;
    }

    public long pow(int base, int time){
        long ans = 1L;
        for (int i = 1; i < time; i++) {
            ans = (ans*base) % mod;
        }
        return ans ;
    }

    public static void main(String[] args){
        int[] nums1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] nums2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0};

        Solution11 solution11 = new Solution11();
        solution11.findLength(nums1,nums2);
    }
}