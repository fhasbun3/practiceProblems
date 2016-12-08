/**
 * Created by Fuad Hasbun on 12/7/2016.
 */
public class Stack<T> {
    public GenericNode<T> top;
    public int size = 0;

    /**
     * This method pushes into the stack
     * @param nodeToAdd
     */
    public void push(GenericNode nodeToAdd) {
        if (top == null) {
            top = nodeToAdd;
        } else {
            nodeToAdd.next = top;
            top = nodeToAdd;
        }
        size++;
    }

    public GenericNode<T> pop() {
        GenericNode<T> nodeToPop = top;
        if (top == null) {
            return null;
        } else {
            top = top.next;
            size--;
        }
        return  nodeToPop;
    }
}
