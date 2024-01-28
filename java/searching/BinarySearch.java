package searching;

/**
 * Binary Search is an efficient searching algorithm that works on sorted arrays.
 * It repeatedly divides the search interval in half to find the target element.
 * The algorithm compares the target element with the middle element of the array
 * and eliminates half of the remaining elements at each step.
 *
 * How Binary Search Works:
 * 1. Initialize two pointers, 'left' and 'right,' to the start and end of the array.
 * 2. Calculate the middle index, 'mid,' as (left + right) / 2.
 * 3. Compare the middle element with the target element.
 *    - If they are equal, the search is successful, and the index is returned.
 *    - If the middle element is less than the target, narrow the search to the right half.
 *    - If the middle element is greater than the target, narrow the search to the left half.
 * 4. Repeat steps 2-3 until the target element is found or the search range becomes empty.
 *
 * Time Complexity:
 * - Best Case: O(1) [constant time for a single element array]
 * - Average Case: O(log n) [logarithmic time for a sorted array]
 * - Worst Case: O(log n) [logarithmic time for a sorted array]
 *
 * Binary Search has a time complexity of O(log n) due to its ability to halve the
 * search interval at each step. It is significantly faster than linear search for
 * large datasets.
 *
 * Space Complexity:
 * The space complexity of Binary Search is O(1) since it uses a constant amount of
 * additional space regardless of the size of the input array. It only requires a few
 * variables to keep track of the search range and the middle index.
 *
 * - GeeksforGeeks: https://www.geeksforgeeks.org/binary-search/
 * - Khan Academy: https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/binary-search
 */


public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int targetElement = 7;

        int result = binarySearch(sortedArray, targetElement);

        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result);
        } else {
            System.out.println("Element " + targetElement + " not found in the array");
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // If target is not present in the array
        return -1;
    }
}

