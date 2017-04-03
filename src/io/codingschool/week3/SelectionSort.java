package io.codingschool.week3;

public class SelectionSort implements Algorithm {

    private int[] numbers;

    public void sort(int[] values) {
        numbers = values;

        // Iterate through the list from 0 to n - 1.
        // After each iteration, the list is sorted in
        // ascending order from 0 to i
        for (int i = 0; i < numbers.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            // Iterate through the unsorted portion of the list,
            // keeping track of the min value
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    minIndex = j;
                }
            }

            // Add the smallest number from the unsorted
            // portion of the list to the end of the
            // sorted portion of the list
            swap(i, minIndex);
        }
    }

    private void swap(int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    public String toString() {
        return "SelectionSort";
    }
}
