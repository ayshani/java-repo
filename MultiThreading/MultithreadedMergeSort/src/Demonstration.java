import java.util.Random;

public class Demonstration {

    private static int SIZE = 25;
    private static Random random = new Random(System.currentTimeMillis());
    private static int[] input = new int[SIZE];

    static private void createTestData() {
        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(10000);
        }
    }

    static private void printArray(int[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++)
            System.out.print(" " + input[i] + " ");
        System.out.println();
    }

    public void main( ) {
        createTestData();

        System.out.println("Unsorted Array");
        printArray(input);
        long start = System.currentTimeMillis();
        (new MultithreadedMergeSortProblem()).mergeSort(0, input.length - 1, input);
        long end = System.currentTimeMillis();
        System.out.println("\n\nTime taken to sort = " + (end - start) + " milliseconds");
        System.out.println("Sorted Array");
        printArray(input);
    }
}
