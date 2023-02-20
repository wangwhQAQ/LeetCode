import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution504 {
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public String convertToBase7(int num) {
        StringBuffer ans = new StringBuffer();
        if (num<0){
            num = -num;
            ans.append('-');
        }
        change(num);

        while (!stack.isEmpty()){
            ans.append(stack.pollLast());
        }
        return ans.toString();
    }

    public void change(int num){
        int k = num/7;
        int p = num%7;
        if (k == 0){
            stack.add(k);
        }else {
            stack.add(p);
            change(k);
        }
    }
}