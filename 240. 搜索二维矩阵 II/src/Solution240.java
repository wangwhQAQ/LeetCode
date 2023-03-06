class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int indexX = 0, indexY = n-1;
        while(indexY >=0 && indexX <= m-1){
            if (matrix[indexX][indexY] == target){
                return true;
            } else if (matrix[indexX][indexY] > target) {
                indexY--;
            } else {
                indexX++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution240 s = new Solution240();
//        s.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}} , 20);
        s.searchMatrix(new int[][]{{1,4},{2,5}},4);
    }
}