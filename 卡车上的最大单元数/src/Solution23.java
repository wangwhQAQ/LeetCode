import java.util.Arrays;

class Solution23 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) ->b[1]-a[1]);
        int index = 0;
        int total = 0;
        while (truckSize > 0){
            if (truckSize - boxTypes[index][0] >= 0){
                truckSize -= boxTypes[index][0];
                total += boxTypes[index][1]*boxTypes[index][0];
                index ++;
            }else {
                break;
            }
        }
        total = total + truckSize*boxTypes[index][1];
        return total;
    }
}
