package StacksAndQueues;

/**
 * Created by Fuad Hasbun on 12/22/2016.
 */
public class AnimalQueue {
    AnimalNode front;
    int size;

    public void enqueue(AnimalNode nodeTOAdd) {
        if (front == null) {
            front = nodeTOAdd;
            size++;
        } else {
            AnimalNode ptrRunner = front;
            while (ptrRunner.next != null) {
                ptrRunner = ptrRunner.next;
            }
            ptrRunner.next = nodeTOAdd;
            size++;
        }
    }

    public AnimalNode dequeue() {
        if (front == null) {
            return null;
        } else {
            AnimalNode nodeToDelete = front;
            front = front.next;
            size--;
            return nodeToDelete;
        }
    }
}