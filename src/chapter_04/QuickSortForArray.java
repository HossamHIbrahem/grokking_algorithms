package chapter_04;

public class QuickSortForArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 10};
        quicksort(array, 0, array.length - 1);
        printArray(array);
    }

    private static void printArray(int[] array) {
        System.out.print("[ ");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println("]");
    }

    private static void quicksort(int[] array, int begin, int end) {
        if (begin >= end) return;
        int mid = partition(array, begin, end);
        quicksort(array, begin, mid - 1);
        quicksort(array, mid + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        int x = array[begin];
        int smallIndex = begin;
        int bigIndex = begin;
        while (++bigIndex <= end) {
            if (array[bigIndex] >= x) {
                continue;
            } else {
                smallIndex++;
                swap(array, smallIndex, bigIndex);
            }
        }
        swap(array, begin, smallIndex);
        return smallIndex;
    }

    private static void swap(int[] array, int lhs, int rhs) {
        int temp = array[lhs];
        array[lhs] = array[rhs];
        array[rhs] = temp;
    }
}
