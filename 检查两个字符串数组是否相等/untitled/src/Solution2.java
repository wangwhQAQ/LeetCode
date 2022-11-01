import java.util.Arrays;
import java.util.stream.Stream;

class Solution2 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer w1 = new StringBuffer();
        StringBuffer w2 = new StringBuffer();
        for (int i = 0; i < word1.length; i++) {
            w1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            w2.append(word2[i]);
        }

        if (w1.toString().equals(w2.toString())){
            return true;
        }
        return false;

    }

    public static void main(String[] args){
        Solution2 s2 =new Solution2();
        String[] word1 = {"ab","c"};
        String[] word2 = {"a","bc"};
        s2.arrayStringsAreEqual(word1,word2);
    }
}