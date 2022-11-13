import java.math.BigDecimal;

public class Solution20 {
    public int subarrayLCM(int[] nums, int k) {
        int num = 0;
        boolean f = false;
        for (int i = 0; i < nums.length; i++) {
            if ( k % nums[i] == 0){
                num++;
                if (k ==nums[i]){
                    f = true;
                }
            }
        }
        if (f){
            return (int) Math.pow(2,num-1);
        }else {
            return (int) Math.pow(2,num);
        }
    }

    public static void main(String[] args) {
        Solution20 s = new Solution20();
        s.subarrayLCM(new int[]{1,2,3}, 6);
    }
}
