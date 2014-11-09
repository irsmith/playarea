package playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Median {

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] a2 = { 9, 10, 11, 12, 13, 14, 15, 16 };
		int[] a3 = { 19, 10, 11, 42, 13, 74, 35, 16 };

		irenesInsertionSort(a3);
		print(a3);

		// create a collection from an array
		List<Integer> aa1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Collections.shuffle(aa1);

		// convert collectoin to array
		Integer[] mmeeww = aa1.toArray(new Integer[0]);


		System.out.println("shuffled:" + a1);

		Collections.sort(aa1);

		System.out.println("median a1:" + calcMedian(a1));
		int both[] = merge(a1, a2);

		float mm = calcMedian(both);
		System.out.println("median a1,a2" + mm);
	}

	private static void irenesInsertionSort(int[] a) {

		for (int i = 1; i < a.length; i++) {
			int j = i;
			while (j > 0 && a[j] < a[j - 1]) {
				int temp = a[j - 1];
				a[j - 1] = a[j];
				a[j] = temp;
				j--;

			}

		}
		print(a);
	}

	private static void print(int[] a) {

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	/**
	 * Merge 2 sorted arrays.
	 * 
	 * @param a1
	 * @param a2
	 * @return
	 */
	private static int[] merge(int[] a1, int[] a2) {
		int both[] = new int[a1.length + a2.length];
		
		if (a1.length == 0) return a2;
		if (a2.length == 0) return a1;
		int i = 0;
		int j=0;
		for (int k=0;k<both.length;k++) {
			if (i == a1.length) {
				both[k] = a2[j++];
			} else 	if (j == a2.length) {
				both[k] = a1[i++];
			} else 	if (a1[i] < a2[j]) {
				both[k] = a1[i++];
			} else {
				both[k] = a2[j++];
			}
			
		}
		return both;
	}

	private static float calcMedian(int[] both) {

		// merge

		float median = -1;
		if (both.length % 2 == 1) {
			int i = (both.length / 2) + 1;
			median = both[i];
		} else {
			median = (both[both.length / 2] + both[(both.length / 2) + 1]) / (float)2;
		}
		return median;
	}
}
