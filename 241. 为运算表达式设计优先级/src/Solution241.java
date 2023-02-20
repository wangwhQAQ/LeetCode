import java.util.ArrayList;
import java.util.List;

class Solution241 {
    enum Symbol{
        //加减乘
        add,
        reduce,
        ride
    }
    public List<Integer> diffWaysToCompute(String expression) {
        char[] exp = expression.toCharArray();
        List<Integer> nums = new ArrayList<>();
        List<Integer> symbol  = new ArrayList<>();

        for (int i = 0; i < exp.length; ) {
            if(Character.isDigit(exp[i])){
                int num = 0;
                while (i < exp.length && Character.isDigit(exp[i])){
                    num = num*10 + ( exp[i]-'0' );
                    i++;
                }
                nums.add(num);
            }else {
                if ('+' == exp[i]){
                    symbol.add(Symbol.add.ordinal());
                }
                else if ('-' == exp[i]){
                    symbol.add(Symbol.reduce.ordinal());
                }
                else if ('*' == exp[i]){
                    symbol.add(Symbol.ride.ordinal());
                }
                i++;
            }
        }

        List[][] dp = new List[nums.size()][nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }

        return dfs(dp , 0 , nums.size()-1 , symbol , nums);
    }

    private List<Integer> dfs(List[][] dp, int left, int right, List<Integer> symbol, List<Integer> nums) {
        if (dp[left][right].isEmpty()){
            if (left == right){
                dp[left][right].add(nums.get(left));
            }else {
                for (int i = left; i < right; i++) {
                    List<Integer> leftAns =  dfs(dp, left , i , symbol, nums);
                    List<Integer> rightAns = dfs(dp , i+1 , right , symbol , nums);
                    for (Integer la : leftAns){
                        for (Integer ra : rightAns){
                            if (symbol.get(i).equals(0)){
                                dp[left][right].add(la+ra);
                            } else if (symbol.get(i).equals(1)) {
                                dp[left][right].add(la-ra);
                            } else if (symbol.get(i).equals(2)) {
                                dp[left][right].add(la*ra);
                            }
                        }
                    }
                }
            }
        }

        return dp[left][right];
    }

    public static void main(String[] args) {
        Solution241 s = new Solution241();
        s.diffWaysToCompute("2-1-1");
    }
}