package SortingAndSearching;
import org.junit.Test;
/**
 * Created by Fuad Hasbun on 5/29/2017.
 */
public class MergeABTest {

    @Test
    public void test1() {
        double[] arrA = {5, 6, 7, 8, 9, Double.NaN, Double.NaN, Double.NaN};
        double[] arrB = {1, 2, 3};
        MergeAB sorted = new MergeAB(arrA, arrB);
        double[] mergedAB = sorted.merge();
    }

}
