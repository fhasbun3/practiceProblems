package StacksAndQueues;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by Fuad Hasbun on 12/18/2016.
 */
public class SetOfStacksTest {

    @Test
    public void pushTestSingleStack() {
        ArrayList<Stack> myStackArrayList = new ArrayList<>();
        SetOfStacks<Integer> mySetOfStacks = new SetOfStacks<>(myStackArrayList, 3);
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        GenericNode<Integer> three = new GenericNode<Integer>(3);
        mySetOfStacks.push(one);
        mySetOfStacks.push(two);
        mySetOfStacks.push(three);
        assertEquals(three, mySetOfStacks.getStackSet().get(0).top);
    }

    @Test
    public void pushTestTwoStack() {
        ArrayList<Stack> myStackArrayList = new ArrayList<>();
        SetOfStacks<Integer> mySetOfStacks = new SetOfStacks<>(myStackArrayList, 3);
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        GenericNode<Integer> three = new GenericNode<Integer>(3);
        mySetOfStacks.push(one);
        mySetOfStacks.push(two);
        mySetOfStacks.push(three);
        assertEquals(three, mySetOfStacks.getStackSet().get(0).top);
        GenericNode<Integer> four = new GenericNode<Integer>(4);
        GenericNode<Integer> five = new GenericNode<Integer>(5);
        GenericNode<Integer> six = new GenericNode<Integer>(6);
        mySetOfStacks.push(four);
        mySetOfStacks.push(five);
        mySetOfStacks.push(six);
        assertEquals(six, mySetOfStacks.getStackSet().get(1).top);
    }

    @Test
    public void popAtIndexTest() {
        ArrayList<Stack> myStackArrayList = new ArrayList<>();
        SetOfStacks<Integer> mySetOfStacks = new SetOfStacks<>(myStackArrayList, 3);
        GenericNode<Integer> one = new GenericNode<Integer>(1);
        GenericNode<Integer> two = new GenericNode<Integer>(2);
        GenericNode<Integer> three = new GenericNode<Integer>(3);
        mySetOfStacks.push(one);
        mySetOfStacks.push(two);
        mySetOfStacks.push(three);
        assertEquals(three, mySetOfStacks.getStackSet().get(0).top);
        GenericNode<Integer> four = new GenericNode<Integer>(4);
        GenericNode<Integer> five = new GenericNode<Integer>(5);
        GenericNode<Integer> six = new GenericNode<Integer>(6);
        mySetOfStacks.push(four);
        mySetOfStacks.push(five);
        mySetOfStacks.push(six);
        assertEquals(six, mySetOfStacks.getStackSet().get(1).top);
        mySetOfStacks.popAtIndex(1);
        assertEquals(five, mySetOfStacks.getStackSet().get(1).top);
        mySetOfStacks.popAtIndex(0);
        assertEquals(two, mySetOfStacks.getStackSet().get(0).top);
    }
}
