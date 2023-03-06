import java.util.HashMap;
import java.util.Map;

class Solution149 {
    public int maxPoints(int[][] points) {
        Map<Double,Integer>[] maps = new Map[points.length];
        int ans = 1;

        for(int i = 0 ; i < maps.length ; i ++){
            maps[i] = new HashMap<Double,Integer>();
            int currentMax = 1;
            for(int j = 0 ; j < points.length ; j ++){
                if(i == j){
                    continue;
                }

                double k = (double)(points[j][1]-points[i][1]) / (double)(points[j][0]-points[i][0]);
                int value = maps[i].getOrDefault(k,1) + 1;
                maps[i].put(k , value);
                currentMax = Math.max(currentMax , value);
            }

            ans = Math.max(ans , currentMax);
        }

        return ans;


    }

    public static void main(String[] args) {
        Solution149 s = new Solution149();
        s.maxPoints(new int[][]{{1,1},{2,2},{3,3}});
    }
}