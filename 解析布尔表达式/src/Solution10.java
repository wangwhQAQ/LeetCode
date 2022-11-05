import java.util.Arrays;
import java.util.Stack;

class Solution10 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (Character c : expression.toCharArray()){
            if (c.equals(',')){
                continue;
            } else if (!c.equals(')')) {
                stack.push(c);
            }else {
                int f = 0, t = 0;
                while (!stack.peek().equals('(')){
                    Character s = stack.pop();
                    if (s.equals('f')){
                        f++;
                    } else if (s.equals('t')){
                        t++;
                    }
                }
                stack.pop();
                Character op = stack.pop();
                if (op.equals('!')){
                    if (f-t > 0){
                        stack.push('t');
                    }else {
                        stack.push('f');
                    }
                } else if (op.equals('&')) {
                    if (f>0){
                        stack.push('f');
                    }else {
                        stack.push('t');
                    }
                } else if (op.equals('|')) {
                    if (t>0){
                        stack.push('t');
                    }else {
                        stack.push('f');
                    }
                }
            }
        }
        return stack.pop() == 't';
    }

    public static void main(String[] args){
        Solution10 s10 = new Solution10();
        s10.parseBoolExpr("|(&(t,f,t),!(t))");
    }
}