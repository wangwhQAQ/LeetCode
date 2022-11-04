import queue.MaxQueue;
import queue.SumQueue;

public class Solution6 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        SumQueue runningCostQueue = new SumQueue();
        MaxQueue chargeTimeQueue = new MaxQueue();
        int index = 0;
        int maxSize = 0;
        while (index <= chargeTimes.length){
            if (runningCostQueue.cost() + chargeTimeQueue.maxNum() > budget){
                runningCostQueue.poll();
                chargeTimeQueue.poll();
            }else {
                if (runningCostQueue.size() > maxSize){
                    maxSize = runningCostQueue.size();
                }
                if (index == chargeTimes.length){
                    break;
                }
                runningCostQueue.add(runningCosts[index]);
                chargeTimeQueue.pushBack(chargeTimes[index]);
                index++;
            }
        }
        return maxSize;
    }


    public static void main(String[] args) {
        Solution6 s = new Solution6();
        int[] c = {500,1,1,1,1};
        int[] r = {1,1,1,1,1};
        s.maximumRobots(c,r,300L);
    }
}
