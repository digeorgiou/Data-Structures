package DoublyLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList(8);

        dll.append(5);
        dll.append(4);
        dll.append(3);
        dll.prepend(6);

        dll.insert(2, 12);

        dll.printDLL();
        System.out.println();
        dll.swapFirstLast();
        dll.printDLL();
        System.out.println();
        dll.swapPairs();
        dll.printDLL();
    }
}
