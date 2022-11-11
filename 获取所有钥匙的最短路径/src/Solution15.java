import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution15 {
    public int shortestPathAllKeys(String[] grid) {
        final int MAX = 0xfffffff;
        int m = grid.length, n = grid[0].length();
        int[][] walk = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int status = 0b111111;
        int[][][] distinct = new int[m][n][status];
        // 初始化迷宫
        Deque<int[]> deque = new LinkedList<>();
        int keyNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                Arrays.fill(distinct[i][j],MAX);
                if (grid[i].charAt(j) == '@'){
                    distinct[i][j][0b000000] = 0;
                    deque.add(new int[]{i, j, 0});
                }else if(grid[i].charAt(j) <= 'z' && grid[i].charAt(j) >= 'a'){
                    keyNum ++;
                }
            }
        }
        int finalStatus = 1;
        for (int i = 1 ; i < keyNum ; i ++){
            finalStatus = ((finalStatus<<1) | 1);
        }
        while(!deque.isEmpty()){
            int[] point = deque.poll();
            int step = distinct[point[0]][point[1]][point[2]];
            for (int i = 0; i < walk.length; i++){
                int[] newPoint = new int[]{point[0]+walk[i][0], point[1]+walk[i][1], point[2]};
                if (newPoint[0] < 0 || newPoint[1] < 0 || newPoint[0] > m-1 || newPoint[1] > n-1){
                    continue;
                }
                char c = grid[newPoint[0]].charAt(newPoint[1]);
                if (c == '#'){
                    continue;
                }
                //捡钥匙
                if (c >= 'a' && c <= 'g' ){
                    newPoint[2] = point[2] | ( 1<<(c-'a') );
                }
                //遇上锁
                if (c >= 'A' && c <= 'G' ){
                    if ((newPoint[2] & ( 1 << (c-'a') )) <= 0){
                        continue;
                    }
                }
                //钥匙捡齐了
                if (newPoint[2] == finalStatus){
                    return step +1;
                }
                //如果走一步，步数小于当前记录的步数
                if (step + 1 < distinct[newPoint[0]][newPoint[1]][newPoint[2]] ){
                    distinct[newPoint[0]][newPoint[1]][newPoint[2]] = step+1;
                    deque.add(newPoint);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        s.shortestPathAllKeys(new String[]{"@Aa"});
    }
}
