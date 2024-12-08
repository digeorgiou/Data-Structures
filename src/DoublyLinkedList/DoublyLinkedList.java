package DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;


    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printDLL() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length ==0){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length+= 1;
    }

    public Node removeLast() {
        Node temp = tail;
        if (length == 0) return null;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length ==0){
            head = newNode;
            tail = newNode;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public Node removeFirst() {
        Node temp = head;
        if (length == 0) return null;
        if (length == 1){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length --;
        return temp;
    }

    public Node get (int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else {
            temp = tail;
            for (int i = length - 1 ; i > index ; i --){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set (int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length) return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index);
        Node before = temp.prev;

        before.next = newNode;
        temp.prev = newNode;
        newNode.next = temp;
        newNode.prev = before;
        length ++;
        return true;

    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();
        Node temp = get(index);
        Node after = temp.next;
        Node before = temp.prev;
        before.next = after;
        after.prev = before;
        temp.next = null;
        temp.prev = null;
        length --;
        return temp;

    }

    public void swapFirstLast() {
        if (length < 2) return;
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        if (length < 2) return;
        Node start = head;
        Node end = tail;
        for (int i = 0; i < length/2 ; i++){
            int temp = start.value;
            start.value = end.value;
            end.value = temp;
            start = start.next;
            end = end.prev;
        }
    }

//    και χωρις να αλλαξουμε απλως τα values
//
//    public void reverse() {
//        Node current = head;
//        Node temp = null;
//
//        while (current != null) {
//            temp = current.prev;
//            current.prev = current.next;
//            current.next = temp;
//            current = current.prev;
//        }
//
//        temp = head;
//        head = tail;
//        tail = temp;
//    }

    public boolean isPalindrome() {
        if (length == 0) return true;
        if (length == 1) return true;

        Node start = head;
        Node end = tail;

        for (int i = 0 ; i < length/2 ; i++ ){
            if(start.value != end.value) return false;
            start = start.next;
            end = end.prev;
        }
        return true;


    }


    public void swapPairs() {
        Node dummy = new Node(0);
        dummy.next = head;
        Node before = dummy;
        while (head != null && head.next != null){
            Node temp = head;
            Node after = head.next;
            before.next = after;
            temp.next = after.next;
            after.next = temp;
            after.prev = before;
            temp.prev = after;
            if (temp.next != null){
                temp.next.prev = temp;
            }
            head = temp.next;
            before = temp;
        }
        head = dummy.next;
        if (head != null) head.prev = null;



    }

    public void swapNodePairs() {
        // Create a placeholder (dummyNode) node to simplify swapping.
        Node dummyNode = new Node(0);

        // Link the dummyNode node to the start of our list.
        dummyNode.next = head;

        // Initialize 'previousNode' to 'dummyNode' to remember the node
        // before each pair we're swapping.
        Node previousNode = dummyNode;

        // Continue as long as there's a pair of nodes to swap.
        while (head != null && head.next != null) {

            // Identify the first node of the pair to swap.
            Node firstNode = head;

            // Identify the second node of the pair to swap.
            Node secondNode = head.next;

            // Connect the previousNode's 'next' pointer to secondNode,
            // essentially skipping over firstNode.
            previousNode.next = secondNode;

            // Connect firstNode to the node after secondNode.
            // This ensures we don't lose the rest of the list.
            firstNode.next = secondNode.next;

            // Connect secondNode back to firstNode,
            // completing the swap.
            secondNode.next = firstNode;

            // Adjust 'prev' pointers for our doubly linked list.
            // Set secondNode's 'prev' to the node before current pair.
            secondNode.prev = previousNode;

            // Set firstNode's 'prev' to secondNode as they've been swapped.
            firstNode.prev = secondNode;

            // If there's a node after our current pair, set its 'prev' to firstNode.
            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            // Move the head pointer to the node after the current pair.
            head = firstNode.next;

            // Update 'previousNode' for the next pair of nodes.
            previousNode = firstNode;
        }

        // After swapping all pairs, update our list's head to
        // start at the node after dummyNode.
        head = dummyNode.next;

        // Ensure the new head's 'prev' is null, indicating the start of list.
        if (head != null) head.prev = null;
    }



}