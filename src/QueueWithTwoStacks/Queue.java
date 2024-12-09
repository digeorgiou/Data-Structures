package QueueWithTwoStacks;

public class Queue {

    public Stack<Integer> getStack1() {
        return stack1;
    }

    public void setStack1(Stack<Integer> stack1) {
        this.stack1 = stack1;
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }


    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        if (this.isEmpty()) return null;
        int popped = stack1.pop();

        return popped;
    }


}
