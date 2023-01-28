import java.util.ArrayList;
import java.util.List;

class Solution48 {
    class  Tuple{
        boolean pacific = false;
        boolean atlantic = false;

        public boolean isPacific() {
            return pacific;
        }

        public void setPacific(boolean pacific) {
            this.pacific = pacific;
        }

        public boolean isAtlantic() {
            return atlantic;
        }

        public void setAtlantic(boolean atlantic) {
            this.atlantic = atlantic;
        }

        public Tuple() {
        }

        public Tuple(boolean pacific, boolean atlantic) {
            this.pacific = pacific;
            this.atlantic = atlantic;
        }
    }



    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] states = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                states[i][j] = 0;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                dfs(heights,i,j,heights[i][j],states);
                if (states[i][j] == 3){
                    List<Integer> t =new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public Tuple dfs(int[][] heights, int i, int j, int fromHeight, int[][] states){
        boolean pacific = false;
        boolean atlantic = false;
        if (i < 0 || j < 0) {
            pacific = true;
            return new Tuple(pacific,atlantic);
        } else if (i ==heights.length || j == heights[0].length) {
            atlantic = true;
            return new Tuple(pacific,atlantic);
        } else if (heights[i][j] > fromHeight) {
            return new Tuple(pacific,atlantic);
        }

        if (states[i][j] == 3){
            return new Tuple(true,true);
        }
//        else if (states[i][j] == 2) {
//            return new Tuple(false,true);
//        }else if (states[i][j] == 1){
//            return new Tuple(true,false);
//        }
        else if (states[i][j] == -1){
            return new Tuple(false,false);
        } else if (states[i][j] == -2) {
            return new Tuple(false,false);
        } else {
            states[i][j] = -2;
            Tuple up = dfs(heights, i-1, j,heights[i][j],states);
            Tuple left = dfs(heights, i, j-1,heights[i][j],states);
            Tuple down = dfs(heights, i, j+1,heights[i][j],states);
            Tuple right = dfs(heights, i+1, j,heights[i][j],states);

            Tuple temp = new Tuple();
            temp.setAtlantic(up.isAtlantic() || left.isAtlantic() || down.isAtlantic() || right.isAtlantic());
            temp.setPacific(up.isPacific() || left.isPacific() || down.isPacific() || right.isPacific());

            if (temp.isPacific() && temp.isAtlantic()){
                states[i][j] = 3;
            } else if (temp.isPacific()) {
                states[i][j] = 1;
            } else if (temp.isAtlantic()) {
                states[i][j] = 2;
            } else {
                states[i][j] = -1;
            }

            return temp;
        }
    }

    public static void main(String[] args) {
        Solution48 s = new Solution48();
        s.pacificAtlantic(new int[][]{{1,1},{1,1},{1,1}});
    }
}