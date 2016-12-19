package StacksAndQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fuad Hasbun on 12/8/2016.
 */
public class QueueTest {

    @Test
    public void queueNull() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(null);
        assertEquals(null, intQueue.front);
    }

    @Test
    public void queueNode() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(new GenericNode<Integer>(1));
        int intQueueFront = intQueue.front.data;
        assertEquals(1, intQueueFront);
    }

    @Test
    public void dequeue() {
        Queue<Integer> intQueue = new Queue<>();
        assertEquals(null, intQueue.dequeue());
    }

    @Test
    public void normalDequeue() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(new GenericNode<Integer>(2));
        int dequeueValue = intQueue.dequeue().data;
        assertEquals(2, dequeueValue);
    }
}
