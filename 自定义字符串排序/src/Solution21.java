
import java.util.HashMap;
import java.util.Map;

class Solution21 {
    public String customSortString(String order, String s) {
        Map<Character,Integer> sMap = new HashMap();
        Map<Character,Integer> orderMap = new HashMap();
        for (char c :s.toCharArray()){
            if (sMap.get(c) != null){
                Integer value = sMap.get(c);
                sMap.put(c,value+1);
            }else {
                sMap.put(c,1);
            }
        }
        StringBuffer str = new StringBuffer();
        for (char c:order.toCharArray()){
            orderMap.put(c,1);
            if (sMap.get(c) != null){
                Integer value = sMap.get(c);
                for (int i = 0 ; i < value; i++){
                    str.append(c);
                }
            }
        }
        StringBuffer other = new StringBuffer();
        for (char c :s.toCharArray()){
            if (orderMap.get(c) == null){
                other.append(c);
            }
        }
        return str.append(other).toString();
    }

    public static void main(String[] args) {
        Solution21 s = new Solution21();
        s.customSortString("kqep", "pekeq");
    }
}