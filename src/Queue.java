/**
 * Created by Fuad Hasbun on 12/7/2016.
 */
public class Queue<T extends Comparable<T>> {
    GenericNode<T> front;
    int size;

    public void enqueue(GenericNode<T> nodeTOAdd) {
        if (front == null) {
            front = nodeTOAdd;
            size++;
        } else {
            GenericNode<T> ptrRunner = front;
            while (ptrRunner.next != null) {
                ptrRunner = ptrRunner.next;
            }
            ptrRunner.next = nodeTOAdd;
            size++;
        }
    }

    public GenericNode<T> dequeue() {
        if (front == null) {
            return null;
        } else {
            GenericNode<T> nodeToDelete = front;
            front = front.next;
            size--;
            return nodeToDelete;
        }
    }
}
