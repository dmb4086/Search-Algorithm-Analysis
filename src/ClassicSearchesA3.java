import com.sun.security.jgss.GSSUtil;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ClassicSearchesA3 {
    static int ops = 0;

    static int linearSearchOrdered(int[] arr, int key) {
        int n = arr.length;
        ops = 0;

        for(int i = 0; i < n; i++) {
            ops++;
            if(arr[i] == key)
                return i;
            else if(arr[i] > key) {
                return -1;
            }
        }

        return -1;
    }

    static int binarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        ops = 0;

        while(start <= end) {
            ops++;
            int mid = (start + end) / 2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    static int interpolationSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        ops = 0;

        while(low <= high && key >= arr[low] && key <= arr[high]) {
            ops++;
            int index = low + (((key - arr[low]) * (high - low)) /
                    (arr[high] - arr[low]));

            if(key == arr[index])
                return index;

            if(key < arr[index])
                high = index - 1;
            else
                low = index + 1;
        }

        return -1;
    }

    static void searchResult(String type, int key, int index) {
        if(index != -1)
            System.out.println(type + ": Found " + key + " at index " + index +
                    " in " + ops + " operations");
        else
            System.out.println(type + ": Did not find " + key + " in " + ops +
                    " operations");
    }

    static void printArray(int arr[]) {
        int n = arr.length;

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    /*
    This function returns an Array of size 1000 with random values from 1 - 10,000

     */
    static int[] ArrGenerator(){
        Random rd = new Random();
        int low = 1;
        int high = 10000;

        int[] arr = new int[1000];

        for (int i = 0 ; i<arr.length; i++){
            int result = rd.nextInt(high-low) + low;
            arr[i] = result;
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int index;
        int key;
//        int[] nums = {15, 98, 7, 22, 9, 61, 57};
        int nums[][] = new int[100][];
        for (int i = 0; i<100;i++){
            nums[i] = ArrGenerator();
        }




//        to print the 2D array
//        System.out.println(Arrays.deepToString(nums));

        ArrayList<Double> LinearAvg = new ArrayList<Double>();
        ArrayList<Double> InterAvg = new ArrayList<Double>();
        ArrayList<Double> BinaryAvg = new ArrayList<Double>();

        for(int i = 0 ; i<100; i++){
            Double TotalBinaryOps = 0.0;
            Double TotalInterOps = 0.0;
            Double TotalLinearOps = 0.0;

            for (int j =0 ; j<1000; j++){
                key = nums[i][j];
//                searchResult("Linear", key, linearSearchOrdered(nums[i], key));
//                searchResult("Binary", key, binarySearch(nums[i], key));
//                searchResult("Interpolation", key, interpolationSearch(nums[i], key));

                linearSearchOrdered(nums[i],key);
                TotalLinearOps += ops;
                binarySearch(nums[i],key);
                TotalBinaryOps += ops;
                interpolationSearch(nums[i],key);
                TotalInterOps += ops;
            }
            LinearAvg.add(TotalLinearOps/1000);
            BinaryAvg.add(TotalBinaryOps/1000);
            InterAvg.add (TotalInterOps/1000);

        }
        Double LinAverage = 0.0;
        for (Double item: LinearAvg) {
            LinAverage+=item;
        }
        Double BinAverage = 0.0;
        for (Double item: BinaryAvg) {
            BinAverage+=item;
        }
        Double ItnAverage = 0.0;
        for (Double item: InterAvg) {
            ItnAverage+=item;
        }
        LinAverage/= 100;
        ItnAverage/= 100;
        BinAverage/= 100;

        System.out.println("Linear Average = "+LinAverage);
        System.out.println("Interpolation Average = "+ItnAverage);
        System.out.println("Binary Average = "+ BinAverage);

        int num2 [] = new int[1000];
        for (int count =0 ; count < 1000; count ++){
            boolean flag = false;
            int Number = (int)(Math.random() * (1000 +1) );
            for (int j = 0; j < 100; j++) {
                if(interpolationSearch(nums[j], Number) != -1){
                    flag = true;
                }
            }
            if(flag){
                num2[count] = Number;
                count++;
            }
        }

        // --------------------------------------------------------------------------------------------------------------------------------

        ArrayList<Double> unsucessfullLinearAvg = new ArrayList<Double>();
        ArrayList<Double> unsucessfullInterAvg = new ArrayList<Double>();
        ArrayList<Double> unsucessfullBinaryAvg = new ArrayList<Double>();

        for(int i = 0 ; i<100; i++){
            Double unsucessfullTotalBinaryOps = 0.0;
            Double unsucessfullTotalInterOps = 0.0;
            Double unsucessfullTotalLinearOps = 0.0;

            for (int j =0 ; j<1000; j++){
                key = num2[i];
//                searchResult("Linear", key, linearSearchOrdered(nums[i], key));
//                searchResult("Binary", key, binarySearch(nums[i], key));
//                searchResult("Interpolation", key, interpolationSearch(nums[i], key));

                linearSearchOrdered(nums[i],key);
                unsucessfullTotalLinearOps += ops;
                binarySearch(nums[i],key);
                unsucessfullTotalBinaryOps += ops;
                interpolationSearch(nums[i],key);
                unsucessfullTotalInterOps += ops;
            }
            unsucessfullLinearAvg.add(unsucessfullTotalLinearOps/1000);
            unsucessfullBinaryAvg.add(unsucessfullTotalBinaryOps/1000);
            unsucessfullInterAvg.add (unsucessfullTotalInterOps/1000);

        }
        Double unsucessfullTotalLinearOps = 0.0;
        for (Double item: unsucessfullLinearAvg) {
            unsucessfullTotalLinearOps+=item;
        }
        Double unsucessfullTotalBinaryOps = 0.0;
        for (Double item: unsucessfullBinaryAvg) {
            unsucessfullTotalBinaryOps+=item;
        }
        Double unsucessfullTotalInterOps = 0.0;
        for (Double item: unsucessfullInterAvg) {
            unsucessfullTotalInterOps+=item;
        }
        unsucessfullTotalLinearOps/= 100;
        unsucessfullTotalInterOps/= 100;
        unsucessfullTotalBinaryOps/= 100;

        System.out.println("Linear Average = "+unsucessfullTotalLinearOps);
        System.out.println("Interpolation Average = "+unsucessfullTotalInterOps);
        System.out.println("Binary Average = "+ unsucessfullTotalBinaryOps);







    }



}