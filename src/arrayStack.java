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
 *
 * My Answer:
 * Equally allocate space for the three stacks in the array
 * have a pointer per stack and a base pointer per stack
 * To push move the pointer (not base pointer)
 * To pop move the pointer (not base pointer)
 * Handle overflow by using up space from the neighboring stack
 * //TODO: Implementation not complete
 */
public class arrayStack {

    //given array
    static char[] array;

    //hold 3 pointers for each stack
    static int stack1, stack2, stack3;
    static int ptr1, ptr2, ptr3;

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
        ptr2 = size/3;
        ptr1 = 0;
        ptr3 = 2 * stack2;
    }

    /**
     * This method pushes into the 1st stack
     * @param value
     */
    public static void push1(char value) {
        //Case were stack is empty
        if (array[ptr1] == 0) {
            array[ptr1] = value;
            ptr1++;
        }
        //Case were the stack starts to overflow to second stack
        else if (ptr1 == stack2) {
            array[ptr1] = value;
            ptr1++;
            if (stack2 == ptr2) {
                stack2++;
                ptr2++;
            } else {
                stack2++;
            }
        }
        //Case were the stack starts to overflow to third stack
        else if (ptr1 == stack3) {
            array[ptr1] = value;
            ptr1++;
            if (stack3 == ptr3) {
                stack3++;
                ptr3++;
            } else {
                stack3++;
            }
        }
        else if (ptr1 == array.length - 1) {
            //automatically pop a value and add
            System.out.println("No more stack space, poping last value to push current value");
            pop1();
            array[ptr1] = value;
        }
    }

    /**
     * This method pushes into 2nd stack
     * @param value
     */
    public static void push2(char value) {
        //Case were stack is empty
        if (array[ptr2] == 0) {
            array[ptr2] = value;
            ptr2++;
        }
        //Case were the stack starts to overflow to third stack
        else if (ptr2 == stack3) {
            array[ptr2] = value;
            ptr2++;
            if (stack3 == ptr3) {
                stack3++;
                ptr3++;
            } else {
                stack3++;
            }
        }
        else if (ptr2 == array.length - 1) {
            //automatically pop a value and add
            System.out.println("No more stack space, poping last value to push current value");
            pop1();
            array[ptr2] = value;
        }
    }

    /**
     * This method pushes into 3rd stack
     * @param value
     */
    public static void push3(char value) {
        //Case were stack is empty
        if (array[ptr3] == 0) {
            array[ptr3] = value;
            ptr3++;
        } else if (ptr3 == array.length - 1) {
            //automatically pop a value and add
            System.out.println("No more stack space, poping last value to push current value");
            pop1();
            array[ptr3] = value;
        }
    }

    /**
     * This method returns poped value from stack1
     * @return
     */
    public static char pop1() {
        return '1';
    }

    /**
     * This method returns poped value from stack2
     * @return
     */
    public static char pop2() {
        return '2';
    }

    /**
     * This method returns poped value from stack3
     * @return
     */
    public static char pop3() {
        return '3';
    }




}
