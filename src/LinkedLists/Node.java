package LinkedLists;

/**
 * Created by Fuad Hasbun on 11/17/2016.
 */
public class Node {
    Node next;
    int data;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this(data, null);
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "LinkedLists.Node Containing: " + data;
    }

}
