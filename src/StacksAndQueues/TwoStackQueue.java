package StacksAndQueues;

/**
 * Created by Fuad Hasbun on 12/18/2016.
 */

import java.util.NoSuchElementException;

/**
 * Interview Question 3.5: Implement a Queue class which implements a queue
 * using two stacks
 */
public class TwoStackQueue<T extends Comparable<? super T>> {
    Stack<T> stack1, stack2;
    //State defining last operation done:
    //i.e. 0 = push and 1 = pop
    boolean lastOperation;

    public TwoStackQueue(Stack<T> stack1, Stack<T> stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
        lastOperation = false;
    }

    public void enqueue(GenericNode<T> nodeToAdd) {
        if (nodeToAdd == null) {
            //Do nothing
        } else {
            //Standard case where you are using the first stack
            if (!lastOperation) {
                stack1.push(nodeToAdd);
            } else {
                //In this case you have to move everything from
                //stack2 to stack1
                while (stack2.size != 0) {
                    stack1.push(stack2.pop());
                }
                stack1.push(nodeToAdd);
            }
            lastOperation = false;
        }
    }

    public GenericNode<T> dequeue(){
        if (lastOperation) {
            lastOperation = true;
            return stack2.pop();
        } else {
            //Move everything into stack2
            while(stack1.size != 1) {
                stack2.push(stack1.pop());
            }
            lastOperation = true;
            return stack1.pop();
        }
    }
}
