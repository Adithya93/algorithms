public class StockPrices {

	public static double computeMaxProfit(double[] arr) {
		if (arr.length < 2) {
			return 0;
		}

		double currentMin = arr[0];
		double maxProfit = Double.MIN_VALUE;
		for (int day = 1; day < arr.length; day ++) {
			if (arr[day] - currentMin > maxProfit) {
				maxProfit = arr[day] - currentMin;
			}
			if (arr[day] < currentMin) {
				currentMin = arr[day];
			}
		}
		return maxProfit;
	}

	public static void printArray(double[] arr) {
          for (int index = 0; index < arr.length-1; index ++) {
              System.out.print(arr[index] + ", ");
          }
          System.out.println(arr[arr.length - 1]);
      }

	public static void main(String[] args) {
		double[] test = new double[]{310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		System.out.println("Original array:");
		printArray(test);
		System.out.println("Max profit: " + computeMaxProfit(test));
	}


}