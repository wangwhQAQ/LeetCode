class Solution168 {
    enum Index{
        //字母表
        A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
    }

    StringBuffer ans = new StringBuffer();

    public String convertToTitle(int columnNumber) {
        change(columnNumber);
        return ans.reverse().toString();
    }

    public void change(int num){
        int b = (num - 1)%26 +1;  // 这里需要注意
        int k = (num - b) / 26;

        if (k == 0 ){
            ans.append(Index.values()[b-1]);
        } else if (k >= 26) {
            ans.append(Index.values()[b-1]);
            change(k);
        } else {
            ans.append(Index.values()[b-1]).append(Index.values()[k-1]);
        }
    }
}