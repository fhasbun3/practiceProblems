package BitManipulation;

import java.util.ArrayList;

/**
 * Created by Fuad Hasbun on 12/25/2016.
 */
public class StandardOperations {

    public void main(String[] args) {
        int myInt = 17;
        System.out.println(this.getBit(myInt,2));
    }

    public int getBit(int bitVal, int i) {
        if ((bitVal & (1 << i)) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int setBit(int bitVal, int i, int value) {
        return bitVal | (1 << i);
    }

    public void clearBit(int bitVal, int i) {

    }

    /**
     * Interview Question 5.1: You are given two 32-bit numbers,
     * N and M, and two bit positions, i and j. Write a method to insert
     * M into N such that M starts at bit j and ends at bit i. You can
     * assume that the bits j through i have eno
     * @param m
     * @param n
     * @return
     */
    public boolean[] fitMtoN(boolean[] m, boolean[] n) {

    }

}
