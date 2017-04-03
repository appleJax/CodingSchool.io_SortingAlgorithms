package io.codingschool.week3;

public class InsertionSort implements Algorithm {

    private int[] numbers;

    public void sort(int[] values) {
        numbers = values;

        // Iterate through the list from 0 to n - 1.
        // After each iteration, the list is sorted in
        // ascending order from 0 to i
        for (int i = 0; i < numbers.length - 1; i++) {

            /* Indexes 0 to i are considered sorted.
             * Iterate backwards from i + 1 to 1, comparing neighboring
             * indexes along the way, swapping values if
             * lowerIndex > higherIndex
             *
             * Effectively, this inserts the new number (i + 1)
             * into its proper position in the sorted portion of the list
             * (now 0 to i + 1)
             *
             * As soon as a lowerIndex is found to be <= higherIndex,
             * the new number is considered to be sorted correctly
             */
            for (int j = i + 1; j > 0; j--) {
                if (numbers[j] >= numbers[j - 1])
                    break;

                swap(j, j - 1);
            }
        }
    }

    private void swap(int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    public String toString() {
        return "InsertionSort";
    }
}
