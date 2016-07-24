public class DutchNationalFlag {

    public static void dutchNationalFlagPartition(int[] arr, int pivotIndex) {
        int pivot = arr[pivotIndex];
        int nextSmallIndex = 0;
        int nextBigIndex = arr.length - 1;
        while (nextSmallIndex <= nextBigIndex) {
            if (arr[nextSmallIndex] <= pivot) {
                nextSmallIndex ++;
            }
            else {
                if (arr[nextBigIndex] <= pivot) {
                    int temp = arr[nextSmallIndex];
                    arr[nextSmallIndex] = arr[nextBigIndex];
                    arr[nextBigIndex] = temp;
                    nextSmallIndex ++;
                    nextBigIndex --;
                }
                else {
                    nextBigIndex --;
                }
            }
        }
        // Move pivots to the end of the small section
        int leftIndex = 0;
        int rightIndex = nextBigIndex;
        while (leftIndex < rightIndex) {
            if (arr[leftIndex] < pivot) {
                leftIndex ++;
            }
            else {
                if (arr[rightIndex] < pivot) {
                    int temp = arr[leftIndex];
                    arr[leftIndex] = arr[rightIndex];
                    arr[rightIndex] = temp;
                    leftIndex ++;
                    rightIndex --;
                }
                else {
                    rightIndex --;
                }
            }
        }
        return;
    }

    public static void printArray(int[] arr) {
        for (int index = 0; index < arr.length-1; index ++) {
            System.out.print(arr[index] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,1,0,5,3,6};
        int pivotIndex = 1;
        System.out.println("Pivot index 1; Original array: ");
        printArray(arr);
        DutchNationalFlag.dutchNationalFlagPartition(arr, pivotIndex);
        System.out.println("Rearranged array: ");
        printArray(arr);
        return;
    }

}



