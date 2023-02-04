import java.util.*;

class Solution55 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.sort(candidates);
        boolean[] vis = new boolean[candidates.length];
        boolean[] cadidateStatus = new boolean[candidates.length];

        dfs(candidates, cadidateStatus, target, stack, 0, 0);

        System.out.println(res.toString());
        return res;
    }

    private void dfs(int[] candidates, boolean[] candidateStatus, int target, Deque<Integer> stack, int num, int sum){
        if (sum > target){
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        } else {
            for (int i = num; i < candidates.length; i++) {
                if (candidateStatus[i] || ( i>0 && candidates[i] == candidates[i-1] && candidateStatus[i-1])){
                    candidateStatus[i] = true;
                    continue;
                }
                sum += candidates[i];
                stack.add(candidates[i]);
                candidateStatus[i] = true;

                dfs(candidates, candidateStatus, target, stack, i+1, sum);

                sum -= candidates[i];
                stack.removeLast();
                candidateStatus[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution55 s = new Solution55();
        int[] input1 = new int[]{10,1,2,7,6,1,5};
        s.combinationSum2(input1, 8);
    }
}