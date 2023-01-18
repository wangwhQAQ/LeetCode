import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution38 {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        char[] ss = s.toCharArray();
        String res = "";
        for (String d :
                dictionary) {
            char[] dd = d.toCharArray();
            int indexD = 0;
            for (int i = 0; i < ss.length; i++) {
                if (indexD == dd.length){
                    res = d;
                    break;
                }
                if (ss[i] == dd[indexD]){
                    indexD++;
                }
            }
            if (indexD == dd.length){
                res = d;
                break;
            }
        }

        return res;
    }
}