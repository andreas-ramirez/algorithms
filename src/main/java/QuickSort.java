import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] unsortedArray = new int[]{1,4,2,5,7,83,13,46,3,23,22,12};
        System.out.println("Initial array:");
        printArrays(unsortedArray);
        System.out.println("After sort:");

        //quick sort and print
        quickSort(unsortedArray);
        printArrays(unsortedArray);
    }

    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        /*step 1 - choose pivot
        can start with last index of array
         */
        //using randomizer will help perform slightly better
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        /*step 2 - partition around pivot
        left pointer > pivot && right point < pivot
        move pointers towards each other with loop
         */
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            //walking left pointer towards right until index value < pointer
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            //walking right pointer towards left until index value > pointer
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            //since left pointer is pointing to larger number and right pointer to smaller - swap them
            swap(array, leftPointer, rightPointer);
        }

        /*
        Step 3 - swap pointers and then quick sort two separate arrays
        swap right pointer back to new pivot (last index)
        user left pointer as reference for which index to sort
         */

        swap(array, leftPointer, highIndex);

        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    //overload method to get proper parameters for primary driver
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    //swap elements once pointers meet/cross
    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    //to print and display arrays
    public static void printArrays(int[] array) {
        int i = 0;
        for (int index : array) {
            System.out.println(index);
        }
    }
}
