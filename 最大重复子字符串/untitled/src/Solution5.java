import java.util.ArrayList;
import java.util.List;

class Solution5 {
    public int maxRepeating(String sequence, String word) {
        char[] sq = sequence.toCharArray();
        char[] w = word.toCharArray();

        int kMax = 0;
        for (int i = 0; i < sq.length; i++) {
            int j = 0;
            if (sq[i] == w[j]){
                int iIndex = i;
                int k = 0;
                for (int l = 0; l <w.length; l++) {
                    if (i+l > sq.length-1 || (sq[i+l] != w[l])){
                        i = i+l;
                        break;
                    }
                    if (l == w.length -1){
                        k++;
                        i = i+l+1;
                        l = -1;
                    }
                }
                if ( k > kMax){
                    kMax = k;
                }
                i = iIndex;
            }
        }
        return kMax;
    }


    public static void main(String[] args){
        String s = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String w = "aaaba";
        Solution5 solution5 = new Solution5();
        solution5.maxRepeating(s,w);
    }
}