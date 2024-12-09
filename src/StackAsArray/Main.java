package StackAsArray;

public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack(5);
        myStack.push(5);
        myStack.push(4);
        myStack.push(2);
        myStack.push(1);
        myStack.push(10);


        myStack.printStack();

        System.out.println(myStack.pop() + "popped");
        System.out.println(myStack.pop() + "popped");

        myStack.printStack();




    }

}
