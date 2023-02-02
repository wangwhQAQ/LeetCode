import java.util.ArrayDeque;
import java.util.Deque;

class Solution51 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char[][] boards;
    boolean[][] status;
    char[] words;

    public boolean exist(char[][] board, String word) {
        this.boards = board;
        this.status = new boolean[board.length][board[0].length];
        this.words = word.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        int res;

        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                if (boards[i][j] == words[0]){
                    if (dfs(i,j,0,stack) > 0){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int dfs(int row, int col, int target, Deque<Character> stack){
        int res = 0;
        char current = boards[row][col];
        stack.add(current);
        status[row][col] = true;
        if (stack.size() == words.length){
            res = 1;
        }

        for (int i = 0; i < dirs.length; i++) {
            int newRow = row + dirs[i][0], newCol = col + dirs[i][1];
            if (stack.size() == words.length){
                break;
            }
            if (newRow >= 0 && newCol >= 0 && newRow < boards.length && newCol < boards[0].length && !status[newRow][newCol] && boards[newRow][newCol] == words[target+1]){
                res += dfs(newRow,newCol,target+1,stack);
            }
        }

        stack.removeLast();
        status[row][col] = false;

        return res;
    }

    public static void main(String[] args) {
        Solution51 s = new Solution51();

        char[][] input1 = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String input2 = "ABCCED";

        s.exist(input1,input2);
    }
}