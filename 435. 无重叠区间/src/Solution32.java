import java.util.Arrays;
import java.util.Comparator;

class Solution32 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int j = 0, num = 1;
        for (int i = j+1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[j][1]){
                continue;
            }else {
                j = i;
                num ++;
            }
        }

        return intervals.length - num;
    }
}