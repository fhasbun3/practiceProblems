package BitManipulation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Fuad Hasbun on 12/25/2016.
 */
public class StandardOperationsTest {

    @Test
    public void getBitTest() {
        StandardOperations myStandard = new StandardOperations();
        assertEquals(1, myStandard.getBit(8, 3));
    }

    @Test
    public void setBitTest() {
        StandardOperations myStandard = new StandardOperations();
        int myInt = 8;
        assertEquals(0, myStandard.getBit(myInt, 1));
        myInt = myStandard.setBit(myInt, 1, 1);
        System.out.println(myInt);
        assertEquals(1, myStandard.getBit(myInt, 1));
    }
}
