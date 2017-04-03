package io.codingschool.week3;

public class BubbleSort implements Algorithm {

    private int[] numbers;

    public void sort(int[] values) {
        numbers = values;

        // Iterate through the list from 0 to n - 1.
        // After each iteration, the list is sorted in
        // ascending order from 0 to i
        for (int i = 0; i < numbers.length; i++) {

            // Iterate through the list backwards from n - 1 to i + 1,
            // comparing neighboring indexes along the way, and
            // swapping values if lowerIndex > higherIndex
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j] < numbers[j - 1])
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
        return "BubbleSort";
    }
}
