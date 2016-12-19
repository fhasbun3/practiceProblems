package StacksAndQueues;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Fuad Hasbun on 12/11/2016.
 */
//TODO: Implementation not complete
public class arrayStackTest {

    @Test
    public void setTripleStackTest(){
        arrayStack myStack = new arrayStack();
        myStack.setTripleStack(9);
        assertEquals(9, myStack.array.length);
        assertEquals(0, myStack.stack1);
        assertEquals(3, myStack.stack2);
        assertEquals(6, myStack.stack3);
    }

    @Test
    public void pushStandard() {
        arrayStack myStack = new arrayStack();
        myStack.setTripleStack(9);
        myStack.push1('a');
        myStack.push2('b');
        myStack.push3('c');
        assertEquals('a', myStack.array[0]);
        assertEquals(1, myStack.ptr1);
        assertEquals('b', myStack.array[3]);
        assertEquals(4, myStack.ptr2);
        assertEquals('c', myStack.array[6]);
        assertEquals(7, myStack.ptr3);
    }

    @Test
    public void push1Test() {
        arrayStack myStack = new arrayStack();
        myStack.setTripleStack(9);
        myStack.push1('a');
        myStack.push1('b');
        myStack.push1('c');
        myStack.push2('d');
        myStack.push2('e');
        myStack.push2('f');
        myStack.push3('g');
        myStack.push3('h');
        myStack.push3('i');

        assertEquals(3, myStack.ptr1);

        myStack.push1('j');

        assertEquals(4, myStack.ptr1);
        assertEquals(4, myStack.stack2);
        assertEquals(6, myStack.ptr2);
        assertEquals('j', myStack.array[3]);

        myStack.push1('k');

        assertEquals(5, myStack.ptr1);
        assertEquals(5, myStack.stack2);
        assertEquals(6, myStack.ptr2);
        assertEquals('k', myStack.array[4]);
    }
}
