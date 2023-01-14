import java.util.Arrays;

public class Solution24 {
    static int N = 100010, MOD = (int)1e9+7;
    static long[] p = new long[N];
    static {
        p[0] = 1;
        for (int i = 1; i < N; i++) {
            p[i] = p[i - 1] * 2 % MOD;
        }
    }

    public int sumSubseqWidths(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int mod = 1000000007;
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum =  (sum + nums[i]*p[i]- nums[i]*p[nums.length-i-1] ) % mod;
        }

        return (int) sum;
    }

    public int sumSubseqWidths2(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int mod = 1000000007;
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum =  (sum + nums[i]*((int) Math.pow(2,i) % mod) - nums[i]*((int) Math.pow(2, nums.length-i-1) % mod)) % mod;
        }

        return (int) sum;
    }


    public static void main(String[] args) {
        Solution24 s = new Solution24();
        s.sumSubseqWidths(new int[]{2,1,3});
    }
}
