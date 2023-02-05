class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int[][] maxArea = new int[matrix.length][matrix[0].length];
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1'){
                maxArea[i][0] = 1;
                max = 1;
            }else {
                maxArea[i][0] = 0;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1'){
                maxArea[0][i] = 1;
                max = 1;
            }else {
                maxArea[0][i] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    maxArea[i][j] = Math.min(maxArea[i-1][j-1], Math.min(maxArea[i][j-1], maxArea[i-1][j])) +1;
                }else {
                    maxArea[i][j] = 0;
                }
                if (max < maxArea[i][j]){
                    max = maxArea[i][j];
                }
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        char[][] input1 = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        Solution221 s = new Solution221();
        s.maximalSquare(input1);
    }
}