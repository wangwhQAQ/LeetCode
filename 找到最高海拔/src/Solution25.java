import java.util.ArrayList;
import java.util.List;

class Solution {
    public int largestAltitude(int[] gain) {
        int[] maxGain = new int[gain.length];
        int[] nowGain = new int[gain.length];
        nowGain[0] = gain[0];
        maxGain[0] = gain[0];
        for (int i = 1; i < gain.length; i++) {
            nowGain[i] = nowGain[i-1] + gain[i];
            if (nowGain[i] > maxGain[i-1]){
                maxGain[i] = nowGain[i];
            }else {
                maxGain[i] = maxGain[i-1];
            }
        }
        return maxGain[gain.length-1] > 0 ? maxGain[gain.length-1]:0;
    }


    public static void main(String[] args){
    }
}