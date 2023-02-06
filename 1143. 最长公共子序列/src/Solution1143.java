class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()){
            String temp = new String(text1);
            text1 = text2;
            text2 = temp;
        }

        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] ans = new int[t1.length+1][t2.length+1];

        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if (t1[i-1] == t2[j-1]){
                    ans[i][j] = ans[i-1][j-1] +1;
                }else {
                    ans[i][j] = Math.max(ans[i][j-1], ans[i-1][j]);
                }
            }
        }

        return ans[t1.length][t2.length];
    }

    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        solution1143.longestCommonSubsequence("psnw", "vozsh");
    }
}