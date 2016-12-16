import com.sun.deploy.xml.GeneralEntity;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Fuad Hasbun on 12/7/2016.
 */
public class StackTest {
    @Test
    public void pushToEmptyStack() {
        Stack<Integer> intStack = new Stack<>();
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        intStack.push(one);
        intStack.size = intStack.size++;
        int intHead = intStack.top.data;
        assertEquals(1, intHead);
    }

    @Test
    public void normalPush() {
        Stack<Integer> intStack = new Stack<>();
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        intStack.push(one);
        intStack.size = intStack.size++;
        intStack.push(two);
        intStack.size = intStack.size++;
        int intHead = intStack.top.data;
        int bottom = intStack.top.next.data;
        assertEquals(2, intHead);
        assertEquals(1, bottom);
    }

    @Test
    public void popNull() {
        Stack<Integer> intStack = new Stack<>();
        assertEquals(null, intStack.pop());
    }

    @Test
    public void normalPop(){
        Stack<Integer> intStack = new Stack<>();
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        intStack.push(one);
        intStack.size = intStack.size++;
        intStack.push(two);
        intStack.size = intStack.size++;
        GenericNode<Integer> popedNode = intStack.pop();
        intStack.size = intStack.size--;
        int popedValue = popedNode.data;
        assertEquals(2, popedValue);
        int headValue = intStack.top.data;
        assertEquals(1, headValue);
    }

    @Test
    public void checkMin() {
        Stack<Integer> intStack = new Stack<>();
        GenericNode<Integer> one = new GenericNode<>(1);
        GenericNode<Integer> two = new GenericNode<>(2);
        GenericNode<Integer> three = new GenericNode<>(3);
        GenericNode<Integer> four = new GenericNode<>(4);
        GenericNode<Integer> five = new GenericNode<>(5);

        intStack.push(five);
        assertEquals(five, intStack.min());
        intStack.push(four);
        assertEquals(four, intStack.min());
    }
}
