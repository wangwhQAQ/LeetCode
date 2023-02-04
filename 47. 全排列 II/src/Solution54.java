import java.util.*;

class Solution54 {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer,Integer> resMap = new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] numsStatus = new boolean[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();


        for (int j = 0; j < nums.length; j++) {
            dfs(nums, numsStatus, j, 1, stack);
        }

        return res;
    }

    private void dfs(int[] nums, boolean[] numsStatus, int num, int deep, Deque<Integer> stack) {
        stack.add(nums[num]);
        numsStatus[num] = true;
        if (deep == nums.length){
            List<Integer> st = new ArrayList<>(stack);
            int hash = 0;
            for (Integer integer : st) {
                hash = (hash * 107 + integer) % 1000007;
            }
            if (resMap.getOrDefault(hash,0).equals(0)){
                res.add(st);
                resMap.put(hash,1);
            }
        }else {
            for (int i = 0; i < numsStatus.length; i++) {
                if (!numsStatus[i]){
                    dfs(nums, numsStatus, i, deep+1, stack);
                }
            }
        }

        stack.removeLast();
        numsStatus[num] = false;
    }

}