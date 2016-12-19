package StacksAndQueues;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Fuad Hasbun on 12/18/2016.
 */
public class TwoStackQueueTest {

    @Test
    public void enqueueTest() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TwoStackQueue<Integer> myQueue = new TwoStackQueue(stack1, stack2);
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        myQueue.enqueue(one);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        myQueue.enqueue(two);

        assertEquals(2, myQueue.stack1.size);
        assertEquals(0, myQueue.stack2.size);
    }

    @Test
    public void enqueuePostPop() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TwoStackQueue<Integer> myQueue = new TwoStackQueue(stack1, stack2);
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        myQueue.enqueue(one);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        myQueue.enqueue(two);
        GenericNode<Integer> three = new GenericNode<Integer>(3);
        myQueue.enqueue(three);
        myQueue.dequeue();
        assertEquals(2, myQueue.stack2.size);
        assertEquals(0, myQueue.stack1.size);
    }

    @Test
    public void dequeuePostPop() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TwoStackQueue<Integer> myQueue = new TwoStackQueue(stack1, stack2);
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        myQueue.enqueue(one);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        myQueue.enqueue(two);
        GenericNode<Integer> three = new GenericNode<Integer>(3);
        myQueue.enqueue(three);
        myQueue.dequeue();
        assertEquals(2, myQueue.stack2.size);
        assertEquals(0, myQueue.stack1.size);
        myQueue.dequeue();
        assertEquals(1, myQueue.stack2.size);
        assertEquals(0, myQueue.stack1.size);
        GenericNode<Integer> four = new GenericNode<Integer>(4);
        myQueue.enqueue(four);
        assertEquals(2, myQueue.stack1.size);
        assertEquals(0, myQueue.stack2.size);
    }

}
