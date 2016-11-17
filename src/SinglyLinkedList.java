import javafx.scene.*;

/**
 * Created by Fuad Hasbun on 11/17/2016.
 */
public class SinglyLinkedList {
    public Node head;
    public int size;

    /**
     * Add a node to front of SLL
     * @param data
     */
    public void addToFront(int data) {
        head = new Node(data, head);
        size++;
    }

    /**
     * Add a node to back of SLL
     * @param data
     */
    public void addToBack(int data) {
        Node currNode = head;
        if (head == null) {
            head = new Node(data);
            size++;
        } else {
            while(currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new Node(data);
            size++;
        }

    }

    /**
     * Interview Question 2.1: Write code to remove duplicates from an
     * unsorted linked list
     *
     * Questions:
     * Singly linked list?
     * Which duplicate do I stay with?
     * What is the data type of list?
     * Assume ints
     *
     * My implementation eliminates ALL possible duplicates in the linked list
     */
    public void removeDuplicates() {
        Node ptr1 = head;
        Node ptr2 = head;
        Node ptr3 = head.next;

        for (int i = 0; i < this.size; i++) {
            while(ptr3 != null) {
                if(ptr3.data == ptr1.data) {
                    ptr2.next = ptr3.next;
                    size--;
                    ptr3 = ptr3.next;
                } else {
                    ptr2 = ptr2.next;
                    ptr3 = ptr3.next;
                }
            }
            ptr1 = ptr1.next;
            ptr2 = ptr1;
            ptr3 = ptr1.next;
            if (ptr3 == null) {
                i = this.size;
            }
        }

    }

    /**
     * Interview Question 2.2: Implement an algorithm to find the kth to last element of a
     * singly linked list
     *
     * Questions:
     * In-place? Example: 1,4,2,7,4,5 where k=2 would the answer be 7? Are we provided size
     * of list? Do I have to worry about k beign to big?
     * @param k kth to last element
     * @return the kth element in the SLL
     */
    public int kthToLastElement(int k) {
        int size = 0;
        Node ptr1 = head;
        while(ptr1.next != null) {
            ptr1 = ptr1.next;
            size++;
        }
        Node kth = head;
        for (int i = 0; i <= (size-1) - k; i++) {
            kth = kth.next;
        }
        return kth.getData();
    }

}
