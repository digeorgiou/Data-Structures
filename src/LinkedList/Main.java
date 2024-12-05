package LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.append(4);


        LinkedList myList2 = new LinkedList(7);
        myList2.append(8);
        myList2.append(7);
        myList2.append(10);
        myList2.append(13);
        myList2.append(14);

        long startTime = System.currentTimeMillis();


        myList.printList();
        System.out.println();
        myList.partitionList2(6);

        myList.printList();
        System.out.println();
        myList2.partitionList2(5);
        myList2.printList();

        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println();
        System.out.println(estimatedTime +" ms");
    }
}
