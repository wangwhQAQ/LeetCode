import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class Solution048 {
    int[][] m;
    public void rotate(int[][] matrix) {
        m = matrix;
        int len = matrix.length;

        for (int i = 0; i <= (len+1)/2; i++) {
            for (int j = i; j < len-1 -i; j++) {
                int[] point1 = new int[]{i,j};
                int[] point2 = new int[]{j,len-1-i};
                int[] point3 = new int[]{len-1-i, len-1-j};
                int[] point4 = new int[]{len-1-j, i};
                exchange(point1,point2,point3,point4);
            }
        }
    }

    public void exchange(int[] point1, int[] point2, int[] point3, int[] point4){
        int temp = m[point1[0]][point1[1]];
        m[point1[0]][point1[1]] = m[point4[0]][point4[1]];
        m[point4[0]][point4[1]] = m[point3[0]][point3[1]];
        m[point3[0]][point3[1]] = m[point2[0]][point2[1]];
        m[point2[0]][point2[1]] = temp;
    }

    public static void main(String[] args) {
        Solution048 s = new Solution048();
        s.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}