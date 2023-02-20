import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution204 {
    public int countPrimesOVERTIME(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n <= 2){
            return 0;
        }
        primes.add(2);
        for (int i = 3; i < n; i++) {
            boolean flag = false;
            for (Integer prime : primes){
                if (prime > Math.sqrt(i)){
                    break;
                }
                if (gcd(i,prime) != 1){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                primes.add(i);
            }
        }

        return primes.size();
    }

    public int gcd(int a , int b){
        return b == 0 ? a:gcd(b,a%b);
    }

    public int countPrimes(int n) {
        boolean[] judge = new boolean[n];
        Arrays.fill(judge,true);
        int ans = 0;

        for (int i = 2; i < n; i++) {
            if (judge[i]){
                ans ++;
                long j = (long) i *i;
                while (j<n){
                    judge[(int) j] = false;
                    j += i;
                }
            }
        }

        return ans;
    }
}