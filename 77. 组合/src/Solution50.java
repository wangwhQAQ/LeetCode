import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution50 {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        boolean[] status = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
            status[i] = false;
        }

        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();

        dfs(nums, status, 0, 0, k, n, stack, res);

        return res;
    }

    private void dfs(int[] nums, boolean[] status, int deep, int start, int maxlen, int numlen, Deque<Integer> stack, List<List<Integer>> res) {
        if (deep == maxlen){
            res.add(new ArrayList<>(stack));
            return;
        } else if (deep > maxlen) {
            return;
        }
        for (int i = start; i < numlen; i++) {
            if (status[i]){
                continue;
            }
            status[i] = true;
            stack.add(nums[i]);
            dfs(nums, status, deep+1, i+1, maxlen, numlen, stack,res);
            status[i] = false;
            stack.removeLast();
        }
    }
}