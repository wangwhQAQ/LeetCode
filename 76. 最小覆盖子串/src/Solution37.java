import java.util.*;

class Solution37 {
    public String minWindow(String s, String t) {
        int left = 0 , right = 0;
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        List<Character> ttt = new ArrayList<>();
        for (int i = 0; i < tt.length; i++) {
            ttt.add(tt[i]);
        }
        int head = 0, len = s.length(),widowLen = 0;
//        window.put(ss[0],1);

        do {
            if (need.size() < t.length() ){
                if (right == ss.length){
                    break;
                }
                if (ttt.contains(ss[right])){
                    need.put(ss[right],need.getOrDefault(ss[right], 0)+1);
//                    window.put(ss[right],window.getOrDefault(ss[right],0)+1);
                }else {
//                    window.put(ss[right],window.getOrDefault(ss[right],0)+1);
                }
                right++;
                widowLen++;
            }else {
                if (widowLen < len){
                    head = left-1;
                    len = widowLen+1;
                }
                left++;
                widowLen--;
                Integer needGet = need.getOrDefault(ss[left-1],0);
                if (needGet.equals(1)){
                    need.remove(ss[left-1]);
                }
//                Integer windowGet = window.get(ss[left]);
//                if (windowGet.equals(1)){
//                    window.remove(ss[left]);
//                }else {
//                    window.put(ss[left],windowGet-1);
//                }
            }
        }while (left != right );

        StringBuffer res = new StringBuffer();
        for (int i = head; i < head+len; i++) {
            res.append(ss[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();

        solution37.minWindow("ADOBECODEBANC" , "ABC");
    }
}