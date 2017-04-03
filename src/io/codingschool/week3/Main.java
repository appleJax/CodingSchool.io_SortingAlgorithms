package io.codingschool.week3;

public class Main {

    private static int[] empty = {};
    private static int[] single = { 2 };
    private static int[] numbers1 = { 5, 2, 1, 30, 23, -10, 397, 0, -0, 6, 5, 5, -15, 15, 31, -3, 0, 30, 8 };
    private static int[] numbers2 = numbers1.clone();
    private static int[] numbers3 = numbers1.clone();
    private static int[] numbers4 = numbers1.clone();
    private static int[] numbers5 = numbers1.clone();
    private static int[] numbers6 = numbers1.clone();

    private static void printList(String title, int[] numbers) {
        System.out.printf("%s: ", title);
        for (int x : numbers)
            System.out.print(x + " ");

        System.out.println();
    }

    private static void testSort(Algorithm algorithm, int[] nums) {
        algorithm.sort(empty);
        algorithm.sort(single);

        printList(algorithm + " (empty)", empty);
        printList(algorithm + " (single)", single);

        printList("Unsorted", nums);
        algorithm.sort(nums);
        printList(algorithm.toString(), nums);

        System.out.println();
    }

    public static void main(String[] args) {

        testSort( new SelectionSort(), numbers1);
        testSort( new BubbleSort(),    numbers2);
        testSort( new InsertionSort(), numbers3);
        testSort( new HeapSort(),      numbers4);
        testSort( new QuickSort(),     numbers5);
        testSort( new MergeSort(),     numbers6);
   }
}
