import java.util.*;

class Solution18 {
    int nums = 0;
    final int MAX = 1000000007;
    int LOW, HIGH;
    public int countGoodStrings(int low, int high, int zero, int one) {
//        LOW = low;
//        HIGH = high;

        int[] ans = new int[110000];
        ans[0] = 1;
        for (int i = 0; i < 110000 && i < high +1; i++) {
            ans[i+zero] += ans[i];
            ans[i+zero] %= MAX;
            ans[i+one] += ans[i];
            ans[i+one] %= MAX;
        }
        int temp = 0;

        for (int i = low; i <= high ; i++) {
            temp  =(temp + ans[i]) %MAX;
        }
        return temp;

//        build(0,zero,one);
//        return nums;
    }

    public void build(int base, int zero, int one){
        if (base >= LOW && base <= HIGH){
            nums = (nums+1) %MAX;
        }
        if (base > HIGH){
            return;
        }
        if (base+zero > HIGH && base+one < HIGH){
            build(base+one,zero,one);
        } else if (base + zero < HIGH && base + one > HIGH) {
            build(base+zero, zero,one);
        } else {
            build(base+zero, zero,one);
            build(base+one,zero,one);
        }
    }

    public static void main(String[] args){
        Solution18 s = new Solution18();
        s.countGoodStrings(20,20,10,1);
    }
}