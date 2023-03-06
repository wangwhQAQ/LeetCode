class Solution338 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        ans[0] = 0;
        ans[1] = 1;

        int index2 = 1;

        for (int i = 1; i < n + 1; i++) {
            if ((i & (i-1)) == 0){
                index2 = i;
            }
            ans[i] = ans[i-index2] +1;
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution338 s = new Solution338();
        s.countBits(4);
    }
}