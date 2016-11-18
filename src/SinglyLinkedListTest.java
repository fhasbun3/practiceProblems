import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.*;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Fuad Hasbun on 11/17/2016.
 */
public class SinglyLinkedListTest {

    @Test
    public void addHead(){
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.addToBack(4);
        assertEquals(4,myList.head.getData());
    }

    @Test
    public void removeDuplicates() {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.addToBack(2);
        myList.addToBack(5);
        myList.addToBack(8);
        myList.addToBack(6);
        myList.addToBack(5);
        myList.addToBack(4);
        myList.addToBack(2);

        myList.removeDuplicates();
        assertEquals(2, myList.head.getData());
        assertEquals(5, myList.head.next.getData());
        assertEquals(8, myList.head.next.next.getData());
        assertEquals(6, myList.head.next.next.next.getData());
        assertEquals(4, myList.head.next.next.next.next.getData());
        assertEquals(null, myList.head.next.next.next.next.next);
    }

    @Test
    public void kthToLastElementTest() {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.addToBack(2);
        myList.addToBack(5);
        myList.addToBack(8);
        myList.addToBack(6);
        myList.addToBack(5);
        myList.addToBack(4);
        myList.addToBack(2);

        assertEquals(4, myList.kthToLastElement(1));
        assertEquals(2, myList.kthToLastElement(0));
    }

    @Test
    public void middleDeleteTest() {
        SinglyLinkedList myList = new SinglyLinkedList();
        Node two = new Node(2);
        Node five = new Node(5);
        Node eight = new Node(8);
        Node six = new Node(6);
        Node five2 = new Node(5);
        Node four = new Node(4);
        Node two2 = new Node(2);
        myList.addNode(two);
        myList.addNode(five);
        myList.addNode(eight);
        myList.addNode(six);
        myList.addNode(five2);
        myList.addNode(four);
        myList.addNode(two2);
        myList.middleDelete(six);

        assertEquals(5, myList.head.next.next.next.data);
    }

    @Test
    public void addLinkedListTest() {
        SinglyLinkedList myList1 = new SinglyLinkedList();
        Node seven = new Node(7);
        Node one = new Node(1);
        Node six  = new Node(6);
        myList1.addNode(seven);
        myList1.addNode(one);
        myList1.addNode(six);

        SinglyLinkedList myList2 = new SinglyLinkedList();
        Node five = new Node(5);
        Node nine = new Node(9);
        Node two = new Node(2);
        myList2.addNode(five);
        myList2.addNode(nine);
        myList2.addNode(two);

        SinglyLinkedList listJustForTest = new SinglyLinkedList();

        SinglyLinkedList myList1plus2 = listJustForTest.addLinkedList(myList1, myList2);

        SinglyLinkedList theoreticalAnswerwer = new SinglyLinkedList();

        Node two2 = new Node(2);
        Node one2 = new Node(1);
        Node nine2 = new Node(9);
        theoreticalAnswerwer.addNode(two2);
        theoreticalAnswerwer.addNode(one2);
        theoreticalAnswerwer.addNode(nine2);
        assertEquals(theoreticalAnswerwer.head.data, myList1plus2.head.data);
        assertEquals(theoreticalAnswerwer.head.next.data, myList1plus2.head.next.data);
        assertEquals(theoreticalAnswerwer.head.next.next.data, myList1plus2.head.next.next.data);
        HashMap<Integer, Boolean> hash = new HashMap<>();
//        System.out.println(hash.get(3));
    }

    @Test
    public void circularTest(){
        SinglyLinkedList myList1 = new SinglyLinkedList();
        Node seven = new Node(7);
        Node one = new Node(1);
        Node six  = new Node(6);
        myList1.addNode(seven);
        myList1.addNode(one);
        myList1.addNode(six);
        myList1.addNode(seven);

        SinglyLinkedList listJustForTest = new SinglyLinkedList();

        Node loopNode = listJustForTest.circularList(myList1);

        assertEquals(seven, loopNode);
    }
}
