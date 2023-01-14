import java.util.Set;

public class Solution26 {
    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        int c = lcm(a,b);

        long left = big;
        long right = (long) small * (long) n;

        while ( left <= right){
            long mid = (left + right) / 2;
            long cnt = mid/big + mid/small + mid/c;
            if (cnt >= n){
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        return (int) ((right+1 ) % MOD);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
