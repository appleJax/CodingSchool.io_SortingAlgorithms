package io.codingschool.week3;

public class MergeSort implements Algorithm {

    private int[] numbers;
    private int[] tempNums;

    // Recursively split the array until each sub array consists
    // of 1 element. Then combine and sort neighboring sub arrays
    // until the entire array is sorted.
    // The original array is first cloned so that the copy can be used
    // to ping-pong sorted sub arrays back and forth.
    //
    // Since the process of splitting/recombining is symmetrical
    // (there is one combination for every split), the final sorted array
    // is guaranteed to be the original array, and not the copy.
    public void sort(int[] values) {
        numbers = values;
        tempNums = values.clone();

        split(tempNums, 0, values.length, numbers);
    }

    // Start is inclusive, end is exclusive
    // e.g. start = 0, end = 10 corresponds to indices 0-9
    private void split(int[] B, int start, int end, int[] A) {
        if (end - start < 2)
            return;

        int middle = (start + end) / 2;

        split(A, start,  middle, B);
        split(A, middle, end,    B);

        merge(B, start, middle, end, A);
    }

    private void merge(int[] A, int start, int middle, int end, int[] B) {
        int i = start;
        int j = middle;

        // Sub arrays are already sorted, so compare elements of sub arrays
        // from beginning to end, placing the smaller of the two in the
        // current index of the combined array
        for (int k = start; k < end; k++) {
            if (i < middle && (j >= end || A[i] <= A[j])) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
        }
    }


    public String toString() {
        return "MergeSort";
    }
}
