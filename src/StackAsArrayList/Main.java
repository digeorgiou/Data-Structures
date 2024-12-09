package StackAsArrayList;

public class Main {

    public static void main(String[] args) {

    Stack<Integer> myStack = new Stack();

    myStack.push(15);
    myStack.push(10);
    myStack.push(92);
    myStack.push(64);
    myStack.push(3);

    myStack.push(12);
        myStack.push(49);
        myStack.push(14);
        myStack.push(31);

    myStack.printStack();

    myStack.sortStack(myStack);

        System.out.println("End result:  ");
        myStack.printStack();

    }
}
