import java.util.ArrayList;

public class InsertionSort {

    /**
     * This method will sort the integer array using insertion sort in java algorithm
     *
     * @param arr
     */
    public static void insertionSort(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int valueToSort = arr.get(i);
            int j = i;
            while (j > 0 && arr.get(j - 1) > valueToSort) {
                arr.set(j,arr.get(j - 1));
                j--;
            }
            arr.set(j,valueToSort);
        }
    }

    public static void populateArray(ArrayList<Integer> B) {
        for (int i = 0; i < B.size(); i++) {
            B.set(i, (int) (Math.random() * 100));
        }
    }
}