import javafx.util.Pair;

class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] ans = new int[strs.length+1][m+1][n+1];
        for (int i = 1; i < strs.length+1; i++) {
            Pair<Integer, Integer> pair = count(strs[i-1]);
            Integer zeroNum = pair.getKey();
            Integer oneNum = pair.getValue();

            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    ans[i][j][k] = ans[i-1][j][k];
                    if (zeroNum <= j && oneNum <= k){
                        ans[i][j][k] = Math.max(ans[i][j][k] , ans[i-1][j-zeroNum][k-oneNum] +1);
                    }
                }
            }
        }

        return ans[strs.length][m][n];
    }

    public Pair<Integer, Integer> count(String s){
        char[] ss = s.toCharArray();

        int first = 0, second = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '1'){
                second++;
            }else {
                first++;
            }
        }
        Pair<Integer,Integer> res = new Pair<>(first,second);
        return res;
    }


    public static void main(String[] args) {
        Solution474 s = new Solution474();
        s.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3);
    }
}