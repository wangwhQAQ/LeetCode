import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution52 {
    int N ;
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        boolean[] cols = new boolean[N];
        boolean[] sum = new boolean[2*N -1];
        boolean[] difference = new boolean[2*N -1];

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dfs(cols, sum, difference, 0, i, stack);
        }

        return res;
    }

    private void dfs(boolean[] cols, boolean[] sum, boolean[] difference, int row, int col, Deque<String> stack){
        cols[col] = true;
        sum[col + row] = true;
        difference[col - row + N-1] = true;

        String currentRow = "";
        for (int i = 0; i < N; i++) {
            if (i == col){
                currentRow += "Q";
            }else {
                currentRow += ".";
            }
        }
        stack.add(currentRow);


        if (row == N-1){
            res.add(new ArrayList<>(stack));
        }else {
            int nextRow = row+1;
            int nextCol;
            for (int i = 0; i < N; i++) {
                nextCol = i;
                if (!cols[nextCol] && !sum[nextCol + nextRow] && !difference[nextCol - nextRow + N-1]){
                    dfs(cols, sum, difference, nextRow, nextCol, stack);
                }
            }
        }

        cols[col] = false;
        sum[col + row] = false;
        difference[col - row + N-1] = false;

        stack.pollLast();
    }

    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        solution52.solveNQueens(4);
    }
}