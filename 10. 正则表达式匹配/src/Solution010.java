class Solution010 {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        for (int i = 0; i < p.length() + 1; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (pp[j-1] == ss[i-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    if (pp[j-1] == '*'){
                        if ( j > 1 && pp[j-2] == '.'){
                            int x = i-1;
                            while(x>0){
                                if (ss[x-1] == ss[x]){
                                    x--;
                                }else {
                                    break;
                                }
                            }
                            dp[i][j] = dp[x][j-2];
                        }else {
                            int x = i-1;
                            while(x>0){
                                if (ss[x-1] == ss[x]){
                                    x--;
                                }else {
                                    break;
                                }
                            }

                            dp[i][j] = dp[x][j-1];

                        }

                    } else if (pp[j-1] == '.') {
                        dp[i][j] = dp[i-1][j-1];

                    }else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution010 s = new Solution010();
        s.isMatch("ab", ".*c");
    }
}