import java.util.*;

public class bubble {
    /*
     A simple program that implements bubble sort
    */
    public static void main(String[] args) {
        int[] test = {2, 5, 3, 1, -4, 6, -5, 0};
        bubbleSort(test);
    }

    public static void bubbleSort(int[] array) {
        System.out.println("unsorted: " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("sorted: " + Arrays.toString(array));
    }

}