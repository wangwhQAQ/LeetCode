import java.util.Arrays;

class Solution9 {
    public String removeOccurrences(String s, String part) {
        s = s.replaceFirst(part,"");
        while(s.contains(part)){
            s = s.replaceFirst(part,"");
        }
        return s;
    }

    public static void main(String[] args){
        Solution9 s9 = new Solution9();
        s9.removeOccurrences("aabababa", "aba");
    }
}