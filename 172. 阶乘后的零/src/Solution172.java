class Solution172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            ans += getTimes(i);
        }

        return ans;
    }

    public int getTimes(int num){
        if (num / 5 == 0){
            return 0;
        }
        else if (num % 5 == 0){
            return getTimes(num/5) +1;
        }else {
            return 0;
        }
    }


}