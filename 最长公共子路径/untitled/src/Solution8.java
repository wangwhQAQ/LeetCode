import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution8 {
    final int MOD = 1000000009;
    int shortest = 0;
    int base = 0;

    public int longestCommonSubpath(int n, int[][] paths) {
        base = n+7;
        int minLength = paths[0].length;
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].length < minLength){
                minLength = paths[i].length;
                shortest = i;
            }
        }
        int left = 0, right = minLength, len;
        while (left<right){
            len = Math.max((right - left)/2, 1);
            if (judge(paths, left+len)){
                left = left+len;
            }else {
                right = left+len-1;
            }
        }
        return left;
    }

    public boolean judge(int[][] path, int len){
        boolean totalFlag = true;

        Set<Long> shorestPathHashSet = new HashSet<>();
        long shortestPathHash1 = rabinKarp(path[shortest],len);
        shorestPathHashSet.add(shortestPathHash1);
        for (int i = 0; i < path[shortest].length - len; i++) {
            long shortestPathHash2 = moveSlidingWindow(shortestPathHash1,path[shortest][i+len],path[shortest][i],len);
            shortestPathHash1 = shortestPathHash2;
            shorestPathHashSet.add(shortestPathHash2);
        }

        for (int i = 0; i < path.length; i++) {
            if (i == shortest){
                continue;
            }

            boolean flag = false;

            long pathHash1 = rabinKarp(path[i], len);
            if (shorestPathHashSet.contains(pathHash1)){
                flag = true;
            }

            for (int j = 0; j < path[i].length - len; j++) {
                long pathHash2 = moveSlidingWindow(pathHash1, path[i][j+len], path[i][j], len);
                pathHash1 = pathHash2;
                if (shorestPathHashSet.contains(pathHash2) || flag){
                    flag = true;
                    break;
                }
            }

            totalFlag = totalFlag & flag;
            if (!totalFlag){
                break;
            }
        }
        return totalFlag;
    }

    public long rabinKarp(int[] path, int len){
        long res = 0L;
        for (int i = 0; i < len; i++) {
            res = (res * base + path[i]) %MOD;
        }
        return res%MOD;
    }

    public long moveSlidingWindow(long res, int add, int remove, int len){
        res = ((res + MOD - remove*pow(base,len))*base + add)  % MOD;
        return res;
    }

    public long pow(int base, int time){
        long ans = 1L;
        for (int i = 1; i < time; i++) {
            ans = (ans*base) % MOD;
        }
        return ans ;
    }

    public static void main(String[] args){
        Solution8 s = new Solution8();
        int[][] a1 = new int[][]{{0, 1, 2, 3, 4}, {2, 3, 4}, {4, 0, 1, 2, 3}};
        int[][] a2 = new int[][]{{0}, {1}, {2}};
        int[][] a3 = new int[][]{{0, 1, 2, 3, 4}, {4,3,2,1,0}};
        s.longestCommonSubpath(5, a1);
    }
}