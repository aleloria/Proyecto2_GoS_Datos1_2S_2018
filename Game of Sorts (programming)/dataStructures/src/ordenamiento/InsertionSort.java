package ordenamiento;

public class InsertionSort {
    public static <T extends Comparable<T>> void insertionSort (T[] list)
    {
        int outCounter, inCounter;
        T temp;
        // Sort list[] into increasing order.
        for (outCounter = 1; outCounter < list.length; outCounter++)
        {
            temp = list[outCounter];
            for (inCounter = outCounter; inCounter > 0 && list[inCounter - 1].compareTo(temp) > 0; inCounter--)
            {
                list[inCounter] = list[inCounter - 1];
            }
            list[inCounter] = temp;
        }
    }
}

