package StacksAndQueues;

/**
 * Created by Fuad Hasbun on 12/7/2016.
 */
public class Stack<T extends Comparable<? super T>> {
    public GenericNode<T> top;
    public int size = 0;
    /**
     * This method pushes into the stack
     * @param nodeToAdd
     */
    public void push(GenericNode<T> nodeToAdd) {
        if (top == null) {
            top = nodeToAdd;
            top.setCurrentMin(nodeToAdd);
            top.setNext(null);
        } else {
            nodeToAdd.next = top;
            top = nodeToAdd;
            if (nodeToAdd.compareTo(top) < 0) {
                top.setCurrentMin(nodeToAdd);
            } else {
                System.out.println(nodeToAdd.compareTo(top));
                top.setCurrentMin(top.next.currentMin);
            }
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

    /**
     * Interview Question 3.2: How would you design a stack which, in addition to push
     * and pop, also has a function min which returns the minimum element?
     * Push, pop, and min should all operate in O(1) time.
     *
     * Questions:
     * Can I edit the conventional push and pop functions?
     * Can I add global variables?
     *
     * My implementation:
     * Every node will have an element called currentMin,
     * which will hold the minimum node at the moment said
     * node was pushed into the stack. In other words,
     * the node at the top of the stack will have the
     * min value
     * @return
     */
    public GenericNode<T> min() {
        return top.currentMin;
    }
}
