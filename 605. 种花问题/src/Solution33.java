class Solution33 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int old1 = -2;
        int f = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0){
                if ( i == flowerbed.length-1){
                    int len = i+2 - old1;
                    f += (len-2)/2;
                    old1 = i;
                }
            } else {
                int len = i - old1;
                f += (len-2)/2;
                old1 = i;
            }
        }

        if (f >= n){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        solution33.canPlaceFlowers(new int[]{1,0}, 1);
    }
}