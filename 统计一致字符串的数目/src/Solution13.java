import java.util.HashSet;
import java.util.Set;

public class Solution13 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allow = new HashSet<>();
        for (char a :
                allowed.toCharArray()) {
            allow.add(a);
        }
        int num = 0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (char w :
                    words[i].toCharArray()) {
                if (!allow.contains(w)) {
                    flag = false;
                }
            }
            if (flag){
                num ++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution13 s = new Solution13();

    }
}
