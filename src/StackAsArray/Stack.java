package StackAsArray;

public class Stack {
    private int[] stack;
    int top;

    Stack(int value) {
        stack = new int[value];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        for (int i = top ; i >= 0 ; i--){
            System.out.println(stack[i]);
        }
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(int value) {
        if (this.isFull()) {
            throw new RuntimeException("Stack Full");
        }
        top += 1;
        stack[top] = value;
    }

    public int pop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }
        int temp = stack[top];
        top --;
        return temp;
    }
}


