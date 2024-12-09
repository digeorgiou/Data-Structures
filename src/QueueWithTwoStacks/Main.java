package QueueWithTwoStacks;

public class Main {

    public static void main(String[] args) {


        Queue myQueue = new Queue();

        myQueue.enqueue(5);
        myQueue.enqueue(10);
        myQueue.enqueue(25);
        myQueue.enqueue(15);
        myQueue.enqueue(35);
        myQueue.enqueue(45);
        myQueue.enqueue(65);
        myQueue.enqueue(23);

        myQueue.dequeue();

        for (int elem : myQueue.getStack1().getStackList()) {
            System.out.print(elem + "  ");
        }


    }
}

