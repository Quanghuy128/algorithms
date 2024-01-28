#  * QuickSort is a divide-and-conquer sorting algorithm that works by selecting
#  * a 'pivot' element from the array and partitioning the other elements into
#  * two sub-arrays according to whether they are less than or greater than the pivot.
#  * The sub-arrays are then recursively sorted.
#  *
#  * How QuickSort Works:
#  * 1. Choose a pivot element from the array.
#  * 2. Partition the array around the pivot, with elements less than the pivot on
#  *    one side and elements greater than the pivot on the other.
#  * 3. Recursively apply QuickSort to the sub-arrays created in the partition step.
#  *
#  * Time Complexity:
#  * - Best Case: O(n log n)
#  * - Average Case: O(n log n)
#  * - Worst Case: O(n^2) [with a poor choice of pivot, but randomized pivot selection
#  *   can mitigate this]
#  *
#  * QuickSort is generally faster in practice than other O(n log n) algorithms such as
#  * Merge Sort and Heap Sort. However, its worst-case time complexity is a consideration
#  * in certain situations, and various techniques are often employed to improve its
#  * performance in practice.
#  *
#  * Space Complexity:
#  * The space complexity of QuickSort is O(log n) for the recursive call stack.
#  *
#  * - GeeksforGeeks: https://www.geeksforgeeks.org/quick-sort/
 
def quicksort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[0]
        less = [x for x in arr[1:] if x <= pivot]
        greater = [x for x in arr[1:] if x > pivot]
        return quicksort(less) + [pivot] + quicksort(greater)

arr = [64, 34, 25, 12, 22, 11, 90]
sorted_array = quicksort(arr)
print("Original Array:", arr)
print("Sorted Array:", sorted_array)
