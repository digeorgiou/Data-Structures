package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

//    public void append(int num){
//        Node newNode = new Node(num);
//        if(length == 0){
//            head = newNode;
//            tail = newNode;
//        }else {
//            tail.next = newNode;
//            this.tail = newNode;
//            this.length += 1;
//        }
//    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;

        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length --;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend (int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length += 1;
    }

    public Node removeFirst() {
        Node pre = head;
        if (length == 0) return null;
        else {
            head = head.next;
            pre.next = null;
        }
        length --;
        if (length == 0){
            tail = null;
        }
        return pre;

    }

    public Node get(int index) {
        if(index >= length || index < 0){
            return null;
        }
        Node temp = head;
        for (int i = 0 ; i < index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index , int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        else if (index == 0){
            prepend(value);
            return true;
        }
        else if(index == length) {
            append(value);
            return true;
        }
        else {
            Node newNode = new Node(value);
            Node temp = get(index - 1);
            newNode.next = temp.next;
            temp.next = newNode;
            length += 1;
            return true;
        }
    }

    public Node remove (int index){
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if(index == length - 1) return removeLast();
        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;

        }
    }


    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public Node findKthFromEnd(int k){
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k ; i++ ){
            if(fast == null) return null;
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void partitionList (int x){
        if(head == null) return;
        if(length == 1) return;
        Node pre = head;
        Node temp = pre.next;
        int count = 0;
        int lengthinit = length;
        while(pre.value > x){
            append(pre.value);
            head = pre.next;
            pre.next = null;
            pre = temp;
            temp = temp.next;
            count += 1;
        }
        while(count < lengthinit-1){
            if(temp.value >= x){
                append(temp.value);
                pre.next = temp.next;
                temp.next = null;
                temp = pre.next;

            }else{
                pre = temp;
                temp = temp.next;
            }
            count++;
        }


    }

    public void partitionList2(int x) {
        if(head == null) return;
        if(length == 1) return;
        Node newNode1 = new Node(1);
        Node newNode2 = new Node(2);
        Node small = newNode1;
        Node big = newNode2;
        Node current = head;

        while(current != null){
            if(current.value >= x){
                big.next = current;
                big = current;
            }
            else{
                small.next = current;
                small = current;
            }
            current = current.next;
        }
//        if(newNode1.next == null || newNode2.next == null){
//            return;
//        }else{

            big.next = null;
            small.next = newNode2.next;
            head = newNode1.next;
//
//        }
    }

    public void partitionList3(int x) {
        // Step 1: Check for an empty list.
        // If the list is empty, there is nothing
        // to partition, so we exit the method.
        if (head == null) return;

        // Step 2: Create two dummy nodes.
        // These dummy nodes act as placeholders
        // to simplify list manipulation.
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Step 3: Initialize pointers for new lists.
        // 'prev1' and 'prev2' will track the end nodes of
        // the two lists that are being created.
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Step 4: Start with the head of the original list.
        Node current = head;

        // Step 5: Iterate through the original list.
        while (current != null) {

            // Step 6: Compare current node value with 'x'.
            // Nodes are partitioned based on their value
            // being less than or greater than/equal to 'x'.

            // Step 6.1: If value is less than 'x',
            // add node to the first list.
            if (current.value < x) {
                prev1.next = current;  // Link node to the end of the first list.
                prev1 = current;       // Update the end pointer of the first list.
            } else {
                // Step 6.2: If value is greater or equal,
                // add node to the second list.
                prev2.next = current;  // Link node to the end of the second list.
                prev2 = current;       // Update the end pointer of the second list.
            }

            // Move to the next node in the original list.
            current = current.next;
        }

        // Step 7: Terminate the second list.
        // This prevents cycles in the list.
        prev2.next = null;

        // Step 8: Connect the two lists.
        // The first list is followed by the second list.
        prev1.next = dummy2.next;

        // Step 9: Update the head of the original list.
        // The head now points to the start of the first list.
        head = dummy1.next;
    }

    public void partitionList4(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }

    public void removeDuplicates() {
        // Step 1: Create a Set to store unique node values.
        // We initialize a HashSet, which allows for fast look-up
        // to check for duplicates later on.
        Set<Integer> values = new HashSet<>();

        // Step 2: Initialize a Node variable 'previous' to null.
        // 'previous' will help us unlink a node if it's a duplicate.
        Node previous = null;

        // Step 3: Initialize 'current' to point to the head node.
        // 'current' will be used to iterate through the linked list.
        Node current = head;

        // Step 4: Begin iteration through the linked list.
        // We will keep iterating until 'current' becomes null,
        // indicating we have reached the end of the list.
        while (current != null) {

            // Step 5: Check for duplicates.
            // We check if the current node's value is already in the set.
            if (values.contains(current.value)) {

                // Step 6: Remove the duplicate node.
                // By setting 'previous.next' to 'current.next',
                // we remove the link to 'current', effectively
                // deleting it from the list.
                previous.next = current.next;

                // Step 7: Update the length of the list.
                // Since we removed a node, we decrement the length by 1.
                length -= 1;

            } else {

                // Step 8: Add unique value to set.
                // If the current value is not a duplicate,
                // we add it to the set for future reference.
                values.add(current.value);

                // Step 9: Update 'previous' node.
                // We set 'previous' to the 'current' node, as we
                // move forward in the list.
                previous = current;
            }

            // Step 10: Move to the next node.
            // We update 'current' to point to the next node in the list,
            // continuing our iteration.
            current = current.next;
        }
    }

    public int binaryToDecimal() {
        if (length == 0) return 0;
        Node temp = head;
        int sum = 0;
        while(temp != null){
            sum = temp.value + 2*sum;
            temp = temp.next;
        }
        return sum;
    }


}