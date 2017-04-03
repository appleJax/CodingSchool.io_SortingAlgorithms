package io.codingschool.week3;

public class QuickSort implements Algorithm {

    private int[] numbers;

    public void sort(int[] values) {
        if (values.length == 0)
            return;

        numbers = values;
        quicksort(0, numbers.length - 1);
    }

    // Sorting Algorithm #1
    // the element at the highest index is set as the pivot
    private void quicksort(int low, int high) {
        int pivotIndex = low;
        int i = low;

        // Set the last element as the pivot
        int pivot = numbers[high];

        // Divide into 2 lists
        while (i < high) {

            // If the current number is greater than the pivot,
            // move on to the next number
            while (numbers[i] > pivot)
                i++;

            // Once a number is found that is less than or equal
            // to the pivot, move that number before all the numbers
            // that are greater than the pivot.
            // Then increase the pivot index so that it sits on a number
            // greater than the pivot
            if (i < high) {
                swap(pivotIndex, i);
                pivotIndex++;
                i++;
            }
        }

        // Swap the pivot value (located at the highest index)
        // with the pivot index, whose value is guaranteed to be greater
        // than the pivot value. Now the pivot value is in its
        // final position, and we can move on to further sort
        // the two sub lists (less than pivot and greater than pivot)
        swap(pivotIndex, high);

        // Recurse
        if (pivotIndex - 1 > low)
            quicksort2(low, pivotIndex - 1);

        if (pivotIndex + 1 < high)
            quicksort2(pivotIndex + 1, high);
    }

    // Sorting Algorithm #2
    // the pivot is chosen from the middle of the list
    private void quicksort2(int low, int high) {
        int i = low;
        int j = high;

        // Get the pivot element from the middle of the list
        int midIndex = (low + high) / 2;
        int pivot = numbers[midIndex];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot)
                i++;

            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot)
                j--;

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        // Recurse
        if (low < j)
            quicksort2(low, j);

        if (i < high)
            quicksort2(i, high);
    }

    private void swap(int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    public String toString() {
        return "QuickSort";
    }
}
