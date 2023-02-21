class Solution67 {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length() , b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
            if ( i < a.length() ){
                carry = carry + a.charAt(a.length()-1-i) - '0';
            }
            if ( i < b.length() ){
                carry = carry + b.charAt(b.length()-1-i) - '0';
            }

            ans.append(carry%2);
            carry = carry/2;
        }

        return ans.reverse().toString();
    }
}