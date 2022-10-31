public class Solution1 {
    public int magicalString(int n) {
        int[] s = new int[n+1];
        int[] base = {1, 2, 2, 1, 1, 2};

        for (int i = 0, index = 4; i < n; i++) {
            if (i < 6){
                s[i] = base[i];
                continue;
            }
            if (s[index] == 1){
                s[i] = -1*(s[i-1] -3);
                index ++;
            }else {
                for (int j = 1 ; j < 3 ; j ++){
                    s[i] = -1*(s[i-j] -3);
                    i =i+2-j;
                }
                index ++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += s[i]%2;
//            System.out.println(s[i]);
        }

//        System.out.println(res);
        return res;

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.magicalString(11);
    }
}
