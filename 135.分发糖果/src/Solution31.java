import java.util.Arrays;

class Solution31 {
    public int candy(int[] ratings) {
        int[] candys1 = new int[ratings.length];
        int[] candys2 = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                candys1[i] = candys1[i-1] +1;
            }
        }

        for (int i =  ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]){
                candys2[i] = candys2[i+1] +1;
            }
        }

        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(candys2[i] , candys1[i]);
        }

        return res+ ratings.length;
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        solution31.candy(new int[]{1,0,2});
    }
}