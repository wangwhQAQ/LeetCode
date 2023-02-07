class Solution650 {
    public int minSteps(int n) {
        int[] ans = new int[n+1];
        ans[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i ; j++) {
                if (i%j == 0){
                    ans[i] = Math.min(ans[i], ans[j] + i/j);
                }
                
            }
        }

        return ans[n];
    }

    public static void main(String[] args) {
        Solution650 s = new Solution650();
        s.minSteps(18);
    }
}