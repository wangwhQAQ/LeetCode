import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int current = 0 , next = 1 , ans = 1;

        while (next < pairs.length){
            if (pairs[current][1] < pairs[next][0]){
                current = next;
                ans ++;
            }
            next++;
        }
        return ans;
    }

    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs , Comparator.comparingInt(p -> p[0]));

        int[] ans = new int[pairs.length];
        Arrays.fill(ans , 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]){
                    ans[i] = Math.max(ans[i] , ans[j] + 1);
                }
            }
        }

        return ans[ans.length-1];
    }

}