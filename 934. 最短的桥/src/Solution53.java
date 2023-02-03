import java.util.ArrayDeque;
import java.util.Deque;

class Solution53 {
    int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    int maxRow, maxCol;
    Deque<int[]> edge = new ArrayDeque<>();

    public int shortestBridge(int[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;

        findIsland(grid);

        int res = expand(grid);
        return res;
    }

    private void findIsland(int[][] grid){

        int[] position = new int[2];
        here:
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if(grid[i][j] == 1){
                    position[0] = i;
                    position[1] = j;
                    break here;
                }
            }
        }

        findEdge(grid, position);
    }

    private void findEdge(int[][] grid, int[] position){
        if (grid[position[0]][position[1]] == 2){
            return;
        } else if (grid[position[0]][position[1]] == 0) {
            edge.add(position);
            grid[position[0]][position[1]] = 2;
        }else {
            grid[position[0]][position[1]] = 2;
            int newRow, newCol;
            for (int i = 0; i < move.length; i++) {
                newRow = position[0] + move[i][0];
                newCol = position[1] + move[i][1];
                if ( !isLegal(newRow, newCol)){
                    continue;
                }else {
                    findEdge(grid, new int[]{newRow, newCol});
                }
            }
        }
    }

    private int expand(int[][] grid){
        int step = 0;
        while (!edge.isEmpty()){
            step ++;
            int size = edge.size();
            for (int i = 0; i < size; i++) {
                int[] position = edge.pollFirst();
                for (int j = 0; j < move.length; j++) {
                    int nextRow = position[0] + move[j][0];
                    int nextCol = position[1] + move[j][1];

                    if (!isLegal(nextRow,nextCol)){
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 0){
                        grid[nextRow][nextCol] = 2;
                        edge.addLast(new int[]{nextRow,nextCol});
                    }
                    if (grid[nextRow][nextCol] == 1){
                        return step;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isLegal(int row, int col){
        return row >= 0 && col >= 0 && row < maxRow && col < maxCol;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();

        int[][] input1 = new int[][]{{0,1,0},{0,0,0},{0,0,1}};

        solution53.shortestBridge(input1);
    }
}