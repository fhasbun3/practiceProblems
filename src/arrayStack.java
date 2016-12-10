/**
 * Created by Fuad Hasbun on 12/10/2016.
 */

import java.util.Arrays;

/**
 * Question 3.1 Describe how you could use a single aray to implement
 * three stacks
 * Questions:
 * Equal size for the three stacks?
 * What to do if one stack goes over given space?
 * Resize into next stack?
 * My implementation: Dynamic stacks
 */
public class arrayStack {
    public static void main(String[] args) {
        arrayStack myarrayStack = new arrayStack(new char[2], 0,0,0);
        arrayStack.setTripleStack(9);
        System.out.println("Size: " + arrayStack.array[0]);
        System.out.println("stack1: " + arrayStack.stack1);
        System.out.println("stack2: " + arrayStack.stack2);
        System.out.println("stack3: " + arrayStack.stack3);
        myarrayStack.push1('a');
        myarrayStack.push2('b');
        myarrayStack.push3('c');
        System.out.println(Arrays.toString(myarrayStack.array));
        System.out.println("stack1: " + arrayStack.stack1);
        System.out.println("stack2: " + arrayStack.stack2);
        System.out.println("stack3: " + arrayStack.stack3);

    }

    //given array
    static char[] array;

    //hold 3 pointers for each stack
    static int stack1, stack2, stack3;

    public arrayStack(char[] array, int stack1, int stack2, int stack3) {
        this.array = array;
        this.stack1 = stack1;
        this.stack2 = stack2;
        this.stack3 = stack3;
    }

    /**
     * This method sets up the array with the pointers
     * equally spaced out (i.e. each stack gets the same
     * amount of space)
     * @param size
     */
    public static void setTripleStack(int size) {
        array = new char[size];
        stack2 = size/3;
        stack1 = 0;
        stack3 = 2 * stack2;
    }

    /**
     * This method pushes into the 1st stack
     * @param value
     */
    public static void push1(char value) {
        if (array[stack1] == 0) {
            array[stack1] = value;
            stack1++;
        } else {
            //TODO: apply logic for overflow
        }
    }

    /**
     * This method pushes into 2nd stack
     * @param value
     */
    public static void push2(char value) {
        if (array[stack2] == 0) {
            array[stack2] = value;
            stack2++;
        } else {
            //TODO: apply logic for overflow
        }
    }

    /**
     * This method pushes into 3rd stack
     * @param value
     */
    public static void push3(char value) {
        if (array[stack3] == 0) {
            array[stack3] = value;
            stack3++;
        } else {
            //TODO: apply logic for overflow
        }
    }

    /**
     * This method returns poped value from stack1
     * @return
     */
    public char pop1() {
        return '1';
    }

    /**
     * This method returns poped value from stack2
     * @return
     */
    public char pop2() {
        return '2';
    }

    /**
     * This method returns poped value from stack3
     * @return
     */
    public char pop3() {
        return '3';
    }




}
