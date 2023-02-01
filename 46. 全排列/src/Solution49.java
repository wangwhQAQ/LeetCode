import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution49 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            return res;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        boolean states[] = new boolean[len];
        dfs(nums, 0, len, stack, states, res);

        return res;
    }

    private void dfs(int[] nums, int deep, int len, Deque<Integer> stack, boolean[] states, List<List<Integer>> res) {
        if (deep == len){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (states[i] == true){
                continue;
            }
            stack.add(nums[i]);
            states[i] = true;
            dfs(nums, deep+1, len, stack ,states ,res);
            states[i] = false;
            stack.removeLast();
        }
    }


}