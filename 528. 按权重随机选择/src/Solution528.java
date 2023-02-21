import java.util.Random;

class Solution528 {
    int[] w;
    int[] pre;
    int total;

    public Solution528(int[] w) {
        this.w = w;
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i-1] + w[i];
        }
        this.total = pre[pre.length-1];
    }

    public int pickIndex() {
        Random random = new Random();
        int k = random.nextInt(total) +1;

        int l = 0 , r = pre.length;
        int mid;
        while (l < r){
            mid = (l+r) /2;

            if (pre[mid] < k){
                l = mid + 1;
            } else if (pre[mid] > k) {
                r = mid;
            }else {
                return mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution528 s = new Solution528(new int[]{3,14,1,7});
        s.pickIndex();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */