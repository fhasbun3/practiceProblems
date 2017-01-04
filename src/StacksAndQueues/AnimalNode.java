package StacksAndQueues;

/**
 * Created by Fuad Hasbun on 12/22/2016.
 */
public class AnimalNode {
    AnimalNode next;
    String data;
    int counter;

    public AnimalNode(AnimalNode next, int counter, String data) {
        this.next = next;
        this.data = data;
        this.counter = counter;
    }

    public String getData() {
        return data;
    }

    public AnimalNode getNext() {
        return next;
    }

    public int getCounter() { return counter; }

    public void setNext(AnimalNode next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "Animal Name: " + data;
    }

}
