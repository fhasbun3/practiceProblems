package StacksAndQueues;

import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Fuad Hasbun on 12/18/2016.
 */

/**
 * Interview Question 3.3 Imagine a (literal) stack of plates. If the stack
 * gets too high, it might topple. Therefore, in real life, we would likely start
 * a new stack when teh previous stack exceeds some threshold. Implement a data
 * structure that mimics this.
 * @param <T>
 */
public class SetOfStacks<T extends Comparable<? super T>> {
    ArrayList<Stack> stackSet;
    int sizeLimit;
    int currentStackIndex;

    public SetOfStacks(ArrayList stackSet, int sizeLimit) {
        this.stackSet = stackSet;
        this.sizeLimit = sizeLimit;
        currentStackIndex = 0;
    }

    public ArrayList<Stack> getStackSet() {
        return stackSet;
    }

    /**
     * This method pushes into a specific stack in the
     * array list of stacks
     * @param value
     */
    public void push(GenericNode<T> value) {
        if (value == null) {
            //Do nothing
        } else if (stackSet.isEmpty()) {
            stackSet.add(new Stack<>());
            stackSet.get(currentStackIndex).push(value);
        } else if (stackSet.get(currentStackIndex).size < sizeLimit) {
            stackSet.get(currentStackIndex).push(value);
        } else {
            stackSet.add(new Stack<>());
            currentStackIndex++;
            stackSet.get(currentStackIndex).push(value);
        }
    }

    /**
     * This method pop's a value of a stack specified by
     * an index i
     * @param i
     * @return
     */
    public GenericNode<T> popAtIndex(int i) {
        Stack indexedStack = stackSet.get(i);
        currentStackIndex--;
        return indexedStack.pop();
    }


}
