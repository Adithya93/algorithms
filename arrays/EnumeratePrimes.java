import java.util.List;
import java.util.ArrayList;

public class EnumeratePrimes {
	public static List<Integer> enumeratePrimes(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n < 2) {
			return list;
		}
		list.add(2);
		boolean isPrime;
		for (int candidate = 3; candidate <= n; candidate ++) {
			isPrime = true;
			for (int num : list) {
				if (candidate % num == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				list.add(candidate);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java EnumeratePrimes <n>");
			return;
		}
		try {
			int n = Integer.parseInt(args[0]);
			List<Integer> result = enumeratePrimes(n);
			System.out.println("The primes between 1 and " + n + " are " + result);
		}
		catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			return;
		}
	}

}