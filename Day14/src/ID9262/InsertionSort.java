package ID9262;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = {5, 2, 9, 1, 5, 6};
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int current = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > current) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = current;
        }
    }
}
