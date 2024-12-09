package QueueAsArray;

import java.util.Arrays;

public class Queue {

    private int[] queue;
    private int top = -1;

    Queue(int value) {
        queue = new int[value];
        top = -1;
    }

    public void enQueue(int val) {

        queue[++top] = val;
    }

    public int deQueue() {
        int num = 0;
        if (queue.length == 0) throw new RuntimeException("Queue is empty");
        num = queue[0];

        queue = Arrays.copyOfRange(queue, 1 , queue.length + 1);
        top--;
        return num;

    }




}
