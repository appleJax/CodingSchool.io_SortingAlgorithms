package io.codingschool.week3;

public class HeapSort implements  Algorithm {

    private int[] numbers;

    public void sort(int[] values) {
        numbers = values;

        // Used to separate the sorted portion of the
        // array from the max heap.
        int sorted = 0;

        buildMaxHeap(numbers);

        // On each iteration, move the largest value of the heap (index 0)
        // to the end of the array, placing the rightmost leaf in its place.
        // Then reorder elements to recreate a max heap again, and repeat
        for (int end = numbers.length - 1; end > 0; end--) {
            swap(0, end);
            maintainHeap(numbers, 0, ++sorted);
        }
    }

    private void buildMaxHeap(int[] numbers) {
        int lastParent = (numbers.length - 2) / 2;

        for (int i = lastParent; i >= 0; i--)
            maintainHeap(numbers, i, 0);
    }


    // Parent(i) = (i - 1) / 2
    // LeftChild(i) = (2 * i) + 1
    // RightChild(i) = (2 * i) + 2
    private void maintainHeap(int[] array, int i, int sorted) {

        int max;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        // Check the left child of the current node, and set it as max
        // if it is greater than the current node
        if (left < array.length - sorted && array[left] > array[i]) {
            max = left;
        } else max = i;

        // Check the right child of the current node, and set it as max
        // if it is greater than the current node and its left child
        if (right < array.length - sorted && array[right] > array[max])
            max = right;

        // If the current node is less than one of its children,
        // swap the nodes so that the greatest value is the parent.
        // Then check the swapped node to make sure it is in its
        // final position
        if (max != i) {
            swap(i, max);
            maintainHeap(array, max, sorted);
        }
    }

    private void swap(int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    public String toString() {
        return "HeapSort";
    }
}
