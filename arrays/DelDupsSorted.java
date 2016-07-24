public class DelDupsSorted {

    public static int delDupSorted(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int validIndex = 0;
        int currentIndex = 0;
        while (currentIndex < arr.length) {
            if (arr[currentIndex] != arr[validIndex]) {
                arr[++validIndex] = arr[currentIndex];
            }
            currentIndex ++;
        }
        return validIndex + 1;
    }

    public static void printArray(int[] arr) {
          for (int index = 0; index < arr.length-1; index ++) {
              System.out.print(arr[index] + ", ");
          }
          System.out.println(arr[arr.length - 1]);
      }

    public static void main(String[] args) {
        int[] test = new int[]{2,3,5,5,7,11,11,11,13};
        System.out.println("Original array: ");
        printArray(test);
        int valids = delDupSorted(test);
        System.out.println("Array with dups removed: ");
        printArray(test);
        System.out.println("Number of valid entries: " + valids);
    }


}
