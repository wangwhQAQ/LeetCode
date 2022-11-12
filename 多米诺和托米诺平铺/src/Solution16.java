import queue.MaxQueue;
import queue.SumQueue;

public class Solution16 {
    public int numTilings(int n) {
        final long MAX = 1000000007;
        long[][] ans = new long[n+1][4];
        ans[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            ans[i][0] = ans[i-1][3] % MAX;
            ans[i][1] = (ans[i-1][0] + ans[i-1][2]) % MAX;
            ans[i][2] = (ans[i-1][0] + ans[i-1][1]) % MAX;
            ans[i][3] = (ans[i-1][3] + ans[i-1][2] + ans[i-1][1] + ans[i-1][0]) % MAX;
        }
        return (int) ans[n][3];
    }


    public static void main(String[] args) {
        Solution16 s = new Solution16();
        s.numTilings(4);
    }
}
