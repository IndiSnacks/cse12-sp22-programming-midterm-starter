/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseArrayListTester {

    private MyArrayList<Object> intArrayList;

    Integer[] intArry = {1,2,3,4,5,6};
    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        intArrayList = new MyArrayList<>(intArry);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        boolean error = false;
        try{
            intArrayList.reverseRegion(0, 8);
        }catch(IndexOutOfBoundsException bad){
            error = true;
        }
        assertTrue("ToIndex out of bounds",error);

        boolean error2 = false;
        try{
            intArrayList.reverseRegion(-1, 2);
        }catch(IndexOutOfBoundsException bad){
            error2 = true;
        }
        assertTrue("fromIndex out of bounds",error2);

    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        boolean error = false;
        try{
            intArrayList.reverseRegion(3, 1);
        }catch(IndexOutOfBoundsException bad){
            error = true;
        }
        assertTrue("FromIndex > ToIndex Index",error);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds and
     * in the middle of the list 
     * (i.e. fromIndex > 0 and toIndex < size-1), 
     * and fromIndex is less than toIndex.
    */
    @Test
    public void testReverseIndexWithinBounds(){
        intArrayList.reverseRegion(1, 3);
        Object[] expected = {1,4,3,2,5,6};
        assertArrayEquals(expected, intArrayList.data);
    }

    /**
     * reversing a arrylist fome one bound to another
    */
    @Test
    public void testReverseCustom(){
        intArrayList.reverseRegion(0, 5);
        Object[] expObjects = {6,5,4,3,2,1};
        assertArrayEquals(expObjects, intArrayList.data);

    }


}
