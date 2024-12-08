package Queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        length ++;
    }

    public Node dequeue() {

        if(length == 0) return null;
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        }else {
            first = first.next;
            temp.next = null;
        }
        length --;
        return temp;

    }

    public Node dequeue2() {
        // If the queue is empty, return null
        if(length == 0) return null;
        // Save a reference to the first node
        Node temp = first;
        // If there is only one node in the queue, set both first and last to null
        if(length == 1) {
            first = null;
            last = null;
        } else {
            // Otherwise, set the first node to be the next node in the queue
            first = first.next;
            // Set the next pointer of the removed node to null
            temp.next = null;
        }
        // Decrease the length of the queue by 1
        length--;
        // Return the removed node
        return temp;
    }

}
