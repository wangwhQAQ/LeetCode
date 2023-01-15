import java.util.Arrays;
import java.util.Comparator;

class Solution34 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long oo1 = o1[1];
                long oo2 = o2[1];
                long oo = oo1 - oo2;
                return (int) (oo % 10000007);
            }
        });

        int num = 0;
        for (int i = 0; i < points.length; i++) {
            int right = points[i][1];
            num ++;
            int j;
            for (j = i+1; j < points.length; j++) {
                if (points[j][0] > right){
                    i = j-1;
                    break;
                }
            }
            if (j == points.length){
                break;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        solution34.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646,2147483647}});
    }
}