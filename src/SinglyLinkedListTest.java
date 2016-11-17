import org.junit.Test;
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
}
