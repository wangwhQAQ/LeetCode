class Solution46 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea,dfs(grid,i,j));
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j){
        int res = 0;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return res;
        }

        grid[i][j] = 0;
        res += 1+ dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1);
        return res;
    }

    public static void main(String[] args) {
        Solution46 s = new Solution46();
        s.maxAreaOfIsland(new int[][]{{0,0,0,0,1}, {0,0,0,0,1}, {0,0,0,1,0}});
    }
}