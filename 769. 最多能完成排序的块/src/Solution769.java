import java.util.*;

class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 1 ;
        int currentMaxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > arr[currentMaxIndex]){
                ans++;
                currentMaxIndex = i;
            }
            if (arr[i] > arr[currentMaxIndex]){
                currentMaxIndex = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution769 s = new Solution769();
        s.maxChunksToSorted(new int[]{1,2,0,3});

        List<Character> stack = new LinkedList<Character>();

        char[] ss = new char[]{'1'};
        int x = ss.length & 1;

        Queue<ListNode> heep = new PriorityQueue<ListNode>(new Comparator<ListNode>(){

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        Iterator<Map.Entry<Integer, Integer>> i = map.entrySet().iterator();

//        Map<Double,Integer>[] maps = new HashMap<Double,Integer>()[100];
    }
}