//Recuperado de: http://pages.cs.wisc.edu/~yinggang/courses/cs302/summer_2012/Example_Code/Lecture_13/SelectionSort.java
import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSort {

    /**
     * main method to test the selectionSort static method
     */

    public static void selectionSort(ArrayList<Integer> data) {

        // just return if the array list is null
        if (data == null)
            return;

        // just return if the array list is empty or only has a single element
        if (data.size() == 0 || data.size() == 1)
            return;

        // declare an int variable to hold value of index at which the element
        // has the smallest value
        int smallestIndex;

        // declare an int variable to hold the smallest value for each iteration
        // of the outer loop
        int smallest;

        // for each index in the array list
        for (int curIndex = 0; curIndex < data.size(); curIndex++) {

            /* find the index at which the element has smallest value */
            // initialize variables
            smallest = data.get(curIndex);
            smallestIndex = curIndex;

            for (int i = curIndex + 1; i < data.size(); i++) {
                if (smallest > data.get(i)) {
                    // update smallest
                    smallest = data.get(i);
                    smallestIndex = i;
                }
            }

            /* swap the value */
            // do nothing if the curIndex has the smallest value
            if (smallestIndex == curIndex)
                ;
                // swap values otherwise
            else {
                int temp = data.get(curIndex);
                data.set(curIndex, data.get(smallestIndex));
                data.set(smallestIndex, temp);
            }

        }
    }
}