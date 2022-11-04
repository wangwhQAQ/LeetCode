package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 最大值队列
 * @author DELL
 */
public class MaxQueue{

    Queue<Integer> queue;
    Deque<Integer> deque;

    public void pushBack(Integer num){
        while (deque.size() > 0 && deque.getLast() < num){
            deque.pollLast();
        }
        deque.offerLast(num);
        queue.add(num);
    }

    public Integer maxNum(){
        Integer max = deque.peekFirst();
        if (max == null){
            max = 0;
        }
        return max;
    }

    public Integer peekFirst(){
        return queue.peek();
    }

    public Integer poll(){
        Integer head = queue.poll();
        if (head != null && head.equals(deque.peekFirst())){
            deque.pollFirst();
        }
        return head;
    }

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
}
