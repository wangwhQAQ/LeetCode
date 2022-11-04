import java.util.concurrent.LinkedTransferQueue;

public class Solution4 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int nums = towers.length;
        int maxSignal = 0;
        int[] maxPoint = {0,0};
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                int[] point = {i,j};
                int signal = 0;
                for (int k = 0; k < nums; k++) {
                    double d = distant(point,towers[k]);
                    if (d <= radius){
                        signal += signal(towers[k],d);
                    }
                }
                if (signal > maxSignal){
                    maxPoint = point;
                    maxSignal = signal;
                }

            }
        }

        return maxPoint;
    }

    public double distant(int[] point1, int[] point2){
       return Math.sqrt((point1[0] - point2[0])*(point1[0] - point2[0]) + (point1[1] - point2[1])*(point1[1] - point2[1]));
    }

    public int signal(int[] point, double d){
        return (int) (point[2]/(1+d));
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[][] t = {{30,34,31},{10,44,24},{14,28,23},{50,38,1},{40,13,6},{16,27,9},{2,22,23},{1,6,41},{34,22,40},{40,10,11}};
        int r = 20;
        s.bestCoordinate(t,r);
    }
}
