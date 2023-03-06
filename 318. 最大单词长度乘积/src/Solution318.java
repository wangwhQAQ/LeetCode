import java.util.HashMap;
import java.util.Map;

class Solution318 {
    public int maxProduct(String[] words) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int current = 0;
            for (int j = 0; j < words[i].length(); j++) {
                current |= 1<<(words[i].charAt(j) - 'a' );
            }

            map.put(i,current);
        }

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            Integer a = map.get(i);
            for (int j = 0; j < words.length; j++) {
                Integer b = map.get(j);
                if ((a&b) == 0 && words[i].length()*words[j].length() > ans){
                    ans = words[i].length()*words[j].length();
                }
            }
        }

        return ans;
    }
}