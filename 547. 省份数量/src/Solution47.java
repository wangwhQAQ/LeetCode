class Solution47 {
    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        for (int i = 0; i < isConnected.length; i++) {
            boolean flag = false;
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1){
                    flag = true;
                    isConnected[i][j] = 0;
                    isConnected[j][i] = 0;
                    dfs(isConnected, j);
                }
            }

            if (flag) {
                province ++;
            }
        }

        return province;
    }

    public void dfs(int[][] isConnected, int i ){
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1){
                isConnected[i][j] = 0;
                isConnected[j][i] = 0;
                dfs(isConnected,j);
            }
        }
    }
}