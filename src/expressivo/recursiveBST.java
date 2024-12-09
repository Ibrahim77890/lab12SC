package expressivo;

/**
 * A utility class for performing recursive binary search on a sorted array.
 */
public class recursiveBST {
    /**
     * Performs a recursive binary search on a sorted array.
     *
     * @param array  the sorted array of integers
     * @param target the value to search for
     * @return the index of the target value if found, or -1 if the target is not in the array
     */
    public static int binarySearchRecursive(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1; // Error case: null or empty array
        }
        return binarySearchRecursiveHelper(array, target, 0, array.length - 1);
    }

    /**
     * Helper method for the recursive binary search.
     *
     * @param array the sorted array of integers
     * @param target the value to search for
     * @param left the left boundary of the search range
     * @param right the right boundary of the search range
     * @return the index of the target value if found, or -1 if the target is not in the array
     */
    private static int binarySearchRecursiveHelper(int[] array, int target, int left, int right) {
        // Base case: search range is empty
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2; // Avoid overflow

        if (array[mid] == target) {
            return mid; // Target found
        } else if (array[mid] > target) {
            return binarySearchRecursiveHelper(array, target, left, mid - 1);
        } else {
            return binarySearchRecursiveHelper(array, target, mid + 1, right);
        }
    }
}
