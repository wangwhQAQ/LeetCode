class Solution343 {
    public int integerBreak(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;

        for (int i = 2; i < n+1; i++) {
            int x= i/2+1 ;
            for (int j = 1; j <= x; j++) {
                ans[i] = Math.max(ans[i] , j*ans[i-j]);
                ans[i] = Math.max(ans[i] , j*(i-j));
            }
        }

        return ans[n];
    }

    public static void main(String[] args) {
        Solution343 s = new Solution343();
        s.integerBreak(6);
    }
}