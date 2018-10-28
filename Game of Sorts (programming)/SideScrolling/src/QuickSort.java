import java.util.ArrayList;
import java.util.Random;
 
public class QuickSort {
private static ArrayList<Integer> inputArray = new ArrayList<Integer>();

    public QuickSort(ArrayList<Integer> inputArray){
        QuickSort.inputArray = inputArray;
    }

    public void startQuickStart(int start,int end){
        int q;
        if(start<end){
            q = partition(start, end);
            startQuickStart(start, q);
            startQuickStart(q+1, end);
        }
    }

    public ArrayList<Integer> getSortedArray(){
        return QuickSort.inputArray;
    }

    int partition(int start,int end){


        int init = start;
        int length = end;

        Random r = new Random();
        int pivotIndex = nextIntInRange(start,end,r);
        int pivot = inputArray.get(pivotIndex);



        while(true){
            while(inputArray.get(length)>pivot && length>start){
                length--;
            }

            while(inputArray.get(init)<pivot && init<end){
                init++;
            }

            if(init<length){
                int temp;
                temp = inputArray.get(init);
                inputArray.set(init,inputArray.get(length));
                inputArray.set(length,temp);
                length--;
                init++;


                for(int i=start;i<=end;i++){

                }
            }else{

                return length;
            }
        }

    }

    // Below method is to just find random integer from given range
    static int nextIntInRange(int min, int max, Random rng) {
           if (min > max) {
              throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
           }
           int diff = max - min;
           if (diff >= 0 && diff != Integer.MAX_VALUE) {
              return (min + rng.nextInt(diff + 1));
           }
           int i;
           do {
              i = rng.nextInt();
           } while (i < min || i > max);
           return i;
        }
}