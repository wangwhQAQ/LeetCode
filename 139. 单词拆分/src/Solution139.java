import java.util.ArrayList;
import java.util.List;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] ss = s.toCharArray();
        boolean[] ans = new boolean[ss.length+1];
        ans[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (String word :
                    wordDict) {
                if (word.length() <= i && s.startsWith(word, i-word.length())) {
                    ans[i] = ans[i-word.length()] || ans[i];

                }

            }
        }
        return ans[ss.length];
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaa");
//        input.add("gs");

        Solution139 s = new Solution139();
        s.wordBreak("aaaaaaa",input);
    }
}