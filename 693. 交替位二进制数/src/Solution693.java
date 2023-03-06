class Solution693 {
    public boolean hasAlternatingBits(int n) {
        int x = 0;

        for(int i = 0 ; i < 31 ; i ++){
            if(i%2 == 0){
                x <<= 1;
                x += 1;
            }else{
                x <<= 1;
            }

            if((x&n) == x && (x&n) == n){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution693 s = new Solution693();
        s.hasAlternatingBits(7);
    }
}