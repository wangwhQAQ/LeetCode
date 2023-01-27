import java.util.*;

class Solution45 {
    private class FrequentNum{
        private int num;
        private int freq = 0;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public FrequentNum() {
        }

        public FrequentNum(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequenceMap.put(nums[i], frequenceMap.getOrDefault(nums[i], 0) +1);
        }
        
        PriorityQueue<FrequentNum> minHeap = new PriorityQueue<>(k, new Comparator<FrequentNum>() {
            @Override
            public int compare(FrequentNum o1, FrequentNum o2) {
                return o2.freq-o1.freq;
            }
        });

        for (Map.Entry<Integer,Integer> e :
                frequenceMap.entrySet()) {
            minHeap.add(new FrequentNum(e.getKey(), e.getValue()));
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            FrequentNum temp = minHeap.poll();
            if (temp == null){
                break;
            }
            res[i] = temp.num;
        }

        return res;
    }
}