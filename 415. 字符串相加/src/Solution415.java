class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();

        if (num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int carry = 0;

        int index1 = num1.length()-1;
        int index2 = num2.length()-1;

        while (index1 >= 0){
            if (index2 >= 0){
                int currentNum = n1[index1] - '0' + n2[index2] - '0' + carry;
                if (currentNum >= 10){
                    carry = 1;
                    ans.append(currentNum - 10);
                }else {
                    carry = 0;
                    ans.append(currentNum);
                }
                index2--;
                index1--;
            } else {
                int currentNum = n1[index1] - '0' + carry;
                if (currentNum >= 10){
                    carry = 1;
                    ans.append(currentNum - 10);
                }else {
                    carry = 0;
                    ans.append(currentNum);
                }
                index1--;
            }
        }

        if (carry == 1){
            ans.append(1);
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Solution415 s = new Solution415();
        s.addStrings("1" , "9");
    }
}