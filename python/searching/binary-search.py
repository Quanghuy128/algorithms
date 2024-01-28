# * Binary Search is an efficient searching algorithm that works on sorted arrays.
#  * It repeatedly divides the search interval in half to find the target element.
#  * The algorithm compares the target element with the middle element of the array
#  * and eliminates half of the remaining elements at each step.
#  *
#  * How Binary Search Works:
#  * 1. Initialize two pointers, 'left' and 'right,' to the start and end of the array.
#  * 2. Calculate the middle index, 'mid,' as (left + right) / 2.
#  * 3. Compare the middle element with the target element.
#  *    - If they are equal, the search is successful, and the index is returned.
#  *    - If the middle element is less than the target, narrow the search to the right half.
#  *    - If the middle element is greater than the target, narrow the search to the left half.
#  * 4. Repeat steps 2-3 until the target element is found or the search range becomes empty.
#  *
#  * Time Complexity:
#  * - Best Case: O(1) [constant time for a single element array]
#  * - Average Case: O(log n) [logarithmic time for a sorted array]
#  * - Worst Case: O(log n) [logarithmic time for a sorted array]
#  *
#  * Binary Search has a time complexity of O(log n) due to its ability to halve the
#  * search interval at each step. It is significantly faster than linear search for
#  * large datasets.
#  *
#  * Space Complexity:
#  * The space complexity of Binary Search is O(1) since it uses a constant amount of
#  * additional space regardless of the size of the input array. It only requires a few
#  * variables to keep track of the search range and the middle index.
#  *
#  * - GeeksforGeeks: https://www.geeksforgeeks.org/binary-search/
#  * - Khan Academy: https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/binary-search

def binary_search(arr, target):
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            return mid  # Element found, return its index
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1  # Element not found

# Example usage:
my_array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target_element = 7

result = binary_search(my_array, target_element)

if result != -1:
    print(f"Element {target_element} found at index {result}")
else:
    print(f"Element {target_element} not found in the array")
