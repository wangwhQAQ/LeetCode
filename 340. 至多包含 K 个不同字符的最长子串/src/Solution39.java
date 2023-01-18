import java.util.HashMap;
import java.util.Map;

class Solution39 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> words = new HashMap<>();
        char[] ss = s.toCharArray();

        int num = 0;
        int left = 0, right = 0;
        int maxLen = 0, head = 0;
        do {
            if (num < k && right<ss.length){
                right++;
                if (words.containsKey(ss[right-1])){
                    words.put(ss[right-1] , words.getOrDefault(ss[right-1],0)+1);
                }else {
                    num++;
                    words.put(ss[right-1] , words.getOrDefault(ss[right-1],0)+1);
                }
            }else{
                if (right<ss.length && words.containsKey(ss[right])){
                    right++;
                    words.put(ss[right-1] , words.getOrDefault(ss[right-1],0)+1);
                }else {
                    if (right-left > maxLen){
                        head = left;
                        maxLen = right - left;
                    }
                    left++;
                    Integer get = words.getOrDefault(ss[left-1], 1);
                    if (get.equals(1)){
                        words.remove(ss[left-1]);
                        num --;
                    }else {
                        get --;
                        words.put(ss[left-1], get);
                    }
                }
            }
        }while (left != ss.length && k!=0);

        return maxLen;
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();

        solution39.lengthOfLongestSubstringKDistinct("aa",0);
    }
}