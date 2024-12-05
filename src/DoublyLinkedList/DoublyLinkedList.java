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
        length++;
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


}