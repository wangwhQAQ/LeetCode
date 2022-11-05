class Solution7 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int num = 1;
        int sum = 0;
        while (true){
            sum += num;
            if (sum > target){
                break;
            }
            num++;
        }
        if ((sum-target) % 2 ==0){
            return num;
        }else {
            num++;
            sum += num;
            if ((sum-target) % 2 ==0){
                return num;
            }else {
                return num+1;
            }
        }
    }
}
