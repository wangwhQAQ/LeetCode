import java.util.Arrays;

class Solution14 {
    public boolean halvesAreAlike(String s) {
        String s1 = s.substring(0,s.length()/2);
        String s2 = s.substring(s.length()/2, s.length());
        String base = "aeiouAEIOU";
        int s1num = 0, s2num = 0;
        for (int i = 0 ; i < s1.length() ; i ++){
            if (base.indexOf(s1.charAt(i)) >= 0){
                s1num++;
            }
            if (base.indexOf(s2.charAt(i)) >= 0){
                s2num++;
            }
        }
        if (s1num == s2num){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution14 s14 = new Solution14();
        s14.halvesAreAlike("MerryChristmas");
    }
}