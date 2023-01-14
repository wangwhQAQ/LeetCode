import java.util.Arrays;

class Solution30 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        int res = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]){
                    s[j] = 0;
                    res ++;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();

        solution30.findContentChildren(new int[]{1,2,3}, new int[]{1,1});
    }
}