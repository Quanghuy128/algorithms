package sorting;

import java.util.Arrays;

/**
 * Merge Sort is a divide-and-conquer sorting algorithm that recursively divides
 * an array into two halves, sorts each half, and then merges the sorted halves
 * to produce a fully sorted array. It was devised by John von Neumann in 1945 and
 * is known for its stable and consistent performance.
 *
 * How Merge Sort Works:
 * 1. Divide: The unsorted array is divided into two halves repeatedly until each
 *    sub-array contains only one element.
 * 2. Conquer: The single-element sub-arrays are considered sorted. Merging starts
 *    by comparing elements from each sub-array and combining them in sorted order.
 * 3. Combine (Merge): The sorted sub-arrays are merged to create larger sorted
 *    sub-arrays. This process is repeated until the entire array is sorted.
 *
 * Time Complexity:
 * - Best Case: O(nlogn)
 * - Average Case: O(nlogn)
 * - Worst Case: O(nlogn)
 *
 * Merge Sort has consistent performance across different input scenarios, making
 * it particularly useful for large datasets. It's important to note that Merge
 * Sort's time complexity is always O(n log n), regardless of the initial order
 * of the elements.
 *
 * Space Complexity:
 * The space complexity of Merge Sort is O(n). It requires additional space for
 * creating temporary arrays during the merging process. This space is proportional
 * to the size of the input array.
 *
 * - GeeksforGeeks: https://www.geeksforgeeks.org/merge-sort/
 */

public class MergeSorting {
    public static void main(String[] args) {
        int[] arrayToSort = {64, 34, 25, 12, 22, 11, 90};

        int[] sortedArray = mergeSort(Arrays.copyOf(arrayToSort, arrayToSort.length));

        UtilHelper.print(sortedArray);
    }
    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
