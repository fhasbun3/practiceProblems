/**
 * Created by Fuad Hasbun on 12/7/2016.
 */
public class GenericNode<T extends Comparable<? super T>> {
    public GenericNode<T> next;
    public T data;
    public GenericNode<T> currentMin;

    public GenericNode(T data, GenericNode next) {
        this.data = data;
        this.next = next;
    }

    public GenericNode(T data) {
        this(data, null);
    }

    public T getData() {
        return data;
    }

    public GenericNode<T> getcurrentMin() { return currentMin; }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

    public void setCurrentMin(GenericNode<T> currentMin) { this.currentMin = currentMin; }

    @Override
    public String toString() {
        return "Node Containing: " + data;
    }

    public int compareTo(GenericNode<T> currentMin) {
        return this.data.compareTo(currentMin.getData());
    }
}
