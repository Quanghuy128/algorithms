package sorting;

/**
 * Merge Sort is a divide-and-conquer sorting algorithm that recursively divides
 * an array into two halves, sorts each half, and then merges the sorted halves
 * to produce a fully sorted array. It is known for its stable and consistent performance.
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
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n log n)
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
 * Tutorial:
 * For a detailed tutorial on Merge Sort, you can refer to resources such as:
 * - GeeksforGeeks: https://www.geeksforgeeks.org/merge-sort/
 * - Wikipedia: https://en.wikipedia.org/wiki/Merge_sort
 * These resources provide step-by-step explanations, visualizations, and
 * implementations of Merge Sort, helping you understand the algorithm more
 * comprehensively.
 */


/**
 * QuickSort is a divide-and-conquer sorting algorithm that works by selecting
 * a 'pivot' element from the array and partitioning the other elements into
 * two sub-arrays according to whether they are less than or greater than the pivot.
 * The sub-arrays are then recursively sorted.
 *
 * How QuickSort Works:
 * 1. Choose a pivot element from the array.
 * 2. Partition the array around the pivot, with elements less than the pivot on
 *    one side and elements greater than the pivot on the other.
 * 3. Recursively apply QuickSort to the sub-arrays created in the partition step.
 *
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n^2) [with a poor choice of pivot, but randomized pivot selection
 *   can mitigate this]
 *
 * QuickSort is generally faster in practice than other O(n log n) algorithms such as
 * Merge Sort and Heap Sort. However, its worst-case time complexity is a consideration
 * in certain situations, and various techniques are often employed to improve its
 * performance in practice.
 *
 * Space Complexity:
 * The space complexity of QuickSort is O(log n) for the recursive call stack.
 *
 * - GeeksforGeeks: https://www.geeksforgeeks.org/quick-sort/
 */

public class QuickSorting {
    public static void main(String[] args) {
        int[] arr = {64, 34, 11, 25, 12, 22, 11, 90};
        arr = quick_sort_v2_stack(arr, 0, arr.length - 1);
        UtilHelper.print(arr);
    }

    private static int[] quick_sort_v1_recursion(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quick_sort_v1_recursion(arr, low, partitionIndex - 1);
            quick_sort_v1_recursion(arr, partitionIndex + 1, high);
        }
        return arr;
    }
    private static int[] quick_sort_v2_stack(int[] arr, int l, int h)
    {
        // create auxiliary stack
        int[] stack = new int[h - l + 1];

        // initialize top of stack
        int top = -1;

        // push initial values in the stack
        stack[++top] = l;
        stack[++top] = h;

        // keep popping elements until stack is not empty
        while (top >= 0) {
            // pop h and l
            h = stack[top--];
            l = stack[top--];

            // set pivot element at it's proper position
            int p = partition(arr, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
