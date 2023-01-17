class Solution35 {
    public int[] twoSum(int[] numbers, int target) {
        int head =  0 , tail = numbers.length-1;
        while (head != tail){
            if (numbers[head] + numbers[tail] > target){
                tail--;
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            }else {
                break;
            }
        }

        return new int[]{head+1,tail+1};
    }
}