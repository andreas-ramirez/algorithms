public class MergeSort {

    public static void main(String[] args) {
        int[] unsortedArray = new int[]{1,4,2,5,7,83,13,46,3,23,22,12};
        System.out.println("Initial array:");
        printArrays(unsortedArray);
        System.out.println("After sort:");

        //quick sort and print
        mergeSortTwo(unsortedArray);
        printArrays(unsortedArray);
    }

    public static void mergeSort(int[] array) {
        //break down array into subarrays of length = 1
        int inputLength = array.length;
        if (inputLength < 2) {
            return;
        }
        int midIndex = inputLength /2;
        int[] leftArr = new int[midIndex];
        int[] rightArr = new int[inputLength - midIndex];

        System.arraycopy(array, 0, leftArr, 0, midIndex);
        //subtract midIndex from i to ensure correct index placement
        System.arraycopy(array, midIndex, rightArr, 0, inputLength - midIndex);

        //run both left and right arrays recursively
        mergeSort(leftArr);
        mergeSort(rightArr);

        //merge sorted arrays
        merge(array, leftArr, rightArr);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;

        // i = leftArray, j = rightArray, k = mergedArray
        int i = 0, j = 0, k = 0;

        while(i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                //iterate left
                i++;
            } else {
                array[k] = right[j];
                //iterate right
                j++;
            }
            //regardless of what size is larger, always iterate the merged array
            k++;
        }
        //while left array has leftover index
        while (i < leftLength) {
            array[k] = left[i];
            i++;
            k++;
        }
        //while right array has leftover index
        while (j < rightLength) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    //more concise method
    public static void mergeSortTwo(int[] array) {
        int inputLength = array.length;
        if(inputLength > 1) {
            int midIndex = inputLength /2;
            int[] leftArr = new int[midIndex];
            int[] rightArr = new int[inputLength - midIndex];

            // (src array)(start)(new array)(start)(length)
            System.arraycopy(array, 0, leftArr, 0, midIndex);
            System.arraycopy(array, midIndex, rightArr, 0, inputLength - midIndex);

            mergeSortTwo(leftArr);
            mergeSortTwo(rightArr);

            int i = 0, j = 0, k = 0;
            while (i < leftArr.length && j < rightArr.length) {
                if (leftArr[i] < rightArr[j]) {
                    array[k] = leftArr[i];
                    i++;
                } else {
                    array[k] = rightArr[j];
                    j++;
                }
                k++;
            }
            //while left array has leftover index
            while (i < leftArr.length) {
                array[k] = leftArr[i];
                i++;
                k++;
            }
            //while right array has leftover index
            while (j < rightArr.length) {
                array[k] = rightArr[j];
                j++;
                k++;
            }
        }
    }

    //to print and display arrays
    public static void printArrays(int[] array) {
        int i = 0;
        for (int index : array) {
            System.out.println(index);
        }
    }
}
