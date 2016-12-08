import javafx.scene.*;
import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

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

    public void addNode(Node n) {
        Node currentNode = head;
        if (head == null) {
            head = n;
            size++;
        } else {
            while ((currentNode.next != null)) {
                currentNode = currentNode.next;
            }
            currentNode.next = n;
            size++;
        }
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

    /**
     * Interview Question 2.3: Implement an algorithm to delete a node in the middle
     * of a singly linked list, given only access to that node
     *
     * Questions:
     * Can we assume that the length of the linked list will be odd?
     * If not, what do we consider middle?
     * @param nodeToDelete
     */
    public void middleDelete(Node nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            System.out.println("Cannot delete null node and/or last element");
        } else {
            Node nextNode = nodeToDelete.next;
            nodeToDelete.data = nextNode.getData();
            nodeToDelete.next = nextNode.next;
        }
    }

    /**
     * Interview Question 2.4: Write code to partition a linked list around a value x
     * such that all nodes less than x come before all nodes greater than or equal to x
     * Questions:
     * What type of linked list (I'll assum singly linked)
     * do we have to order the components on the left and right (I'll assume you don't)
     * @param x
     */
    public void xPartition(int x) {
        SinglyLinkedList before = new SinglyLinkedList();
        SinglyLinkedList after = new SinglyLinkedList();
        Node ptr1 = head;
        while(ptr1 != null) {
            if (ptr1.data < x) {
                before.addToFront(ptr1.data);
            } else {
                after.addToFront(ptr1.data);
            }
            ptr1 = ptr1.next;
        }
        Node beforeHead = before.head;
        while(beforeHead.next != null) {
            beforeHead = beforeHead.next;
        }
        beforeHead.next = after.head;
    }

    /**
     * Interview Question 2.5: You have two numbers represented by a linkd list, where each node contains
     * a single digit. The digits are stored in reverse order, such that the 1's digit is at the head
     * of the list. Write a function that adds the two numbers and returns the sum as a linked list
     *
     * Questions:
     * Is it a singly-linked list?
     * Any size restrictions?
     * Are we given the size of the linked lists? (I'll assume we aren't)
     * @param list1
     * @param list2
     * @return
     */
    public SinglyLinkedList addLinkedList(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList additionResult = new SinglyLinkedList();
        int overflow = 0; //value that overflows into the next position
        if (list1.head == null || list2.head == null) {
            return new SinglyLinkedList();
        } else {
            Node ptr1 = list1.head;
            Node ptr2 = list2.head;
            while (ptr1 != null || ptr2 != null) {
                if (ptr1.getData() + ptr2.getData() > 9) {
                    overflow = 1;
                } else {
                    overflow = 0;
                }
                if (overflow == 0) {
                    additionResult.addNode(new Node(ptr1.data + ptr2.data));
                } else {
                    additionResult.addNode(new Node((ptr1.data + ptr2.data)%10));
                    if (ptr1.next != null) {
                        ptr1.next.data = ptr1.next.data + overflow;
                    } else if (ptr2.next != null) {
                        ptr2.next.data = ptr2.next.data + overflow;
                    } else {
                        System.out.println("Something went wrong");
                    }
                }
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        return additionResult;
    }

    /**
     * Interview Question 2.6: Given a circular linked list, implement an algorithm which returns
     * the node at the beginning of the loop
     * @param circularList
     * @return
     */
    public Node circularList(SinglyLinkedList circularList) {
        HashMap<Node, Node> checkCircular = new HashMap<>();
        Node ptr1 = circularList.head;
        while(ptr1.next != null) {
            if (checkCircular.containsKey(ptr1) && checkCircular.get(ptr1).equals(ptr1.next)) {
                return ptr1;
            } else {
                checkCircular.put(ptr1, ptr1.next);
            }
            ptr1 = ptr1.next;
        }
        return null;
    }

    /**
     * Question 2.7 Implement a function to check if a linked list is a palindrome
     * Questions:
     * Singly linked?
     * Do we have access to the tail?
     * Access to the size of the linked list?
     * Assumptions:
     * Singly-linked
     * no access to tail
     * no access to size
     * @param palindromeLL
     * @return
     */
    public boolean isPalindrome(SinglyLinkedList palindromeLL) {
        if (palindromeLL == null) {
            return false;
        }
        boolean answer = true;
        int pLLsize = palindromeLL.size;
        Stack<Integer> evenStack = new Stack<>();
        Stack<Integer> oddStack = new Stack<>();
        Node slowRunner = palindromeLL.head;
        Node fastRunner = palindromeLL.head;

        while (fastRunner != null && fastRunner.next != null) {
                evenStack.add(slowRunner.data);
                oddStack.add(slowRunner.data);
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next.next;
        }

        Node evenPtr = slowRunner;
        Node oddPtr = slowRunner.next;

        boolean evenPalindrome = true;
        boolean oddPalindrome = true;
        while (evenPtr != null) {
            if(evenPtr.data == evenStack.pop()) {
                evenPtr = evenPtr.next;
            } else {
                evenPtr = null;
                evenPalindrome = false;
            }
        }
        while (oddPtr != null) {
            if(oddPtr.data == oddStack.pop()) {
                oddPtr = oddPtr.next;
            } else {
                oddPtr = null;
                oddPalindrome = false;
            }
        }
        return  (evenPalindrome || oddPalindrome);
    }
}
