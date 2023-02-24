import java.util.HashMap;
import java.util.Map;

class Solution202 {
    public boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(n,1);

        int currentSum = 0;
        while (n != 1){
            currentSum = 0;
            int k = n / 10 , b = n % 10;
            while(k != 0){
                currentSum += b*b;
                b = k%10;
                k /= 10;

            }
            currentSum += b*b;
            n = currentSum;
            if (map.getOrDefault(n,0) == 1){
                return false;
            }
            map.put(n,1);
        }

        return true;
    }
}