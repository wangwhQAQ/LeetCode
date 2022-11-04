package queue;

import java.util.LinkedList;
import java.util.Queue;

public class SumQueue {
    Queue<Integer> queue;

    Long sum;

    public void add(Integer num){
        sum += num;
        queue.add(num);
    }

    public Integer peek(){
        return queue.peek();
    }

    public Integer poll(){
        Integer head = queue.peek();
        if (head != null){
            sum -= head;
        }
        return queue.poll();
    }

    public Integer size(){
        return queue.size();
    }

    /* solution6 需要 */
    public Long cost(){
        return sum *queue.size();
    }

    public SumQueue() {
        queue = new LinkedList<>();
        sum = 0L;
    }
}
