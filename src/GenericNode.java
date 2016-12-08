/**
 * Created by Fuad Hasbun on 12/7/2016.
 */
public class GenericNode<T> {
    public GenericNode<T> next;
    public T data;

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

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "Node Containing: " + data;
    }
}
