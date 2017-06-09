import edu.princeton.cs.algs4.Merge;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Gen on 6/4/17.
 */
public class ParallelMergeSort {
    public static void main(String[] args) {
        final int SIZE = 8000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            list1[i] = list2[i] = (int)(Math.random() * 10000000);
        }

        long startTime = System.currentTimeMillis();
        parallelMergeSort(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallelMergeSort time with " + Runtime.getRuntime().availableProcessors()
            + " processors is " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        MergeSort.mergeSort(list2);
        endTime = System.currentTimeMillis();
        System.out.println("\nMergeSort time is " + (endTime - startTime) + "ms");
    }

    public static void parallelMergeSort(int[] list) {
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask extends RecursiveAction {
        private final int THRESHOLD = 7000000;
        private int[] list;

        SortTask(int[] list) {
            this.list = list;
        }
        @Override
        protected void compute() {
            if (list.length < THRESHOLD) {
                java.util.Arrays.sort(list);
            } else {
                int[] firstHalf = new int[list.length / 2];
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

                int secondHalfLength = list.length - list.length / 2;
                int[] secondHalf = new int[secondHalfLength];
                System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
                invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));
                MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
    }
}
