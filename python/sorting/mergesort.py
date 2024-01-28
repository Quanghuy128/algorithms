
# * Merge Sort is a divide-and-conquer sorting algorithm that recursively divides
#  * an array into two halves, sorts each half, and then merges the sorted halves
#  * to produce a fully sorted array. It was devised by John von Neumann in 1945 and
#  * is known for its stable and consistent performance.
#  *
#  * How Merge Sort Works:
#  * 1. Divide: The unsorted array is divided into two halves repeatedly until each
#  *    sub-array contains only one element.
#  * 2. Conquer: The single-element sub-arrays are considered sorted. Merging starts
#  *    by comparing elements from each sub-array and combining them in sorted order.
#  * 3. Combine (Merge): The sorted sub-arrays are merged to create larger sorted
#  *    sub-arrays. This process is repeated until the entire array is sorted.
#  *
#  * Time Complexity:
#  * - Best Case: O(nlogn)
#  * - Average Case: O(nlogn)
#  * - Worst Case: O(nlogn)
#  *
#  * Merge Sort has consistent performance across different input scenarios, making
#  * it particularly useful for large datasets. It's important to note that Merge
#  * Sort's time complexity is always O(n log n), regardless of the initial order
#  * of the elements.
#  *
#  * Space Complexity:
#  * The space complexity of Merge Sort is O(n). It requires additional space for
#  * creating temporary arrays during the merging process. This space is proportional
#  * to the size of the input array.
#  *
#  * - GeeksforGeeks: https://www.geeksforgeeks.org/merge-sort/

def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    left = merge_sort(left)
    right = merge_sort(right)

    return merge(left, right)


def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])

    return result

# Example usage:
my_array = [64, 34, 25, 12, 22, 11, 90]
sorted_array = merge_sort(my_array)
print("Original Array:", my_array)
print("Sorted Array:", sorted_array)
