package Stack;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        for (int i = 0 ; i < height ; i++){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void push (int value){
        Node newNode = new Node (value);
        if (height == 0) {
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if(height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }
}
