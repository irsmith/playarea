package arrays;
import java.util.Arrays;

public class SortedArraySum {
	static boolean findSum(int[] a, int v) {

		Arrays.sort(a);
		int i = 0;
		int j = a.length - 1;
		while (i < j) {

			int sum = a[j] + a[i];
			if (sum == v)
				return true;
			if (sum < v) {
				i++;
			} else {
				j--;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(findSum(new int[] {3,5,6,3,8}, 14));
	}
}
