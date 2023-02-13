class Solution583 {
    public int minDistance(String word1, String word2) {
        int[][] ans = new int[word1.length() + 1][word2.length() + 1];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        for (int i = 0; i < word1.length() + 1; i++) {
            ans[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            ans[0][i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (w1[i-1] == w2[j-1]){
                    ans[i][j] = ans[i-1][j-1];
                }else {
                    ans[i][j] = Math.min(ans[i-1][j] , ans[i][j-1]) +1 ;
                }
            }
        }

        return ans[word1.length()][word2.length()];
    }
}