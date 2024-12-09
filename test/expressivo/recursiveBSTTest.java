package expressivo;

import static org.junit.Assert.*;

import org.junit.*;


public class recursiveBSTTest {

    @Test
    public void testBinarySearchRecursive_found() {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, recursiveBST.binarySearchRecursive(array, 7));
    }

    @Test
    public void testBinarySearchRecursive_notFound() {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(-1, recursiveBST.binarySearchRecursive(array, 4));
    }

    @Test
    public void testBinarySearchRecursive_emptyArray() {
        int[] array = {};
        assertEquals(-1, recursiveBST.binarySearchRecursive(array, 7));
    }

    @Test
    public void testBinarySearchRecursive_nullArray() {
        int[] array = null;
        assertEquals(-1, recursiveBST.binarySearchRecursive(array, 7));
    }

    @Test
    public void testBinarySearchRecursive_firstElement() {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(0, recursiveBST.binarySearchRecursive(array, 1));
    }

    @Test
    public void testBinarySearchRecursive_lastElement() {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(6, recursiveBST.binarySearchRecursive(array, 13));
    }
}
