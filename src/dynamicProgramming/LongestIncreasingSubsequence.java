package dynamicProgramming;

import java.util.Arrays;

//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

public class LongestIncreasingSubsequence {

	class Data {
		int length;
		int maxSoFar;

		public Data(int length, int m) {
			super();
			this.length = length;
			this.maxSoFar = m;
		}
	}

	int lis_helper(int a[]) {
		int maxSoFar = Integer.MIN_VALUE;
		int len = 0; // length so far. If len=1 then we are at a[0]
		Data data = _lis(a, maxSoFar, len);
		return data.length;
	}

	private Data _lis(int[] a, int max_ref, int len) {
		if (len == 1)
			return new Data(1, max_ref);// ?? not sure about what max should be

		Data thisdata = null;
		int res, max_ending_here = 1; // length of LIS ending with arr[n-1]

		/*
		 * Recursively get all LIS ending with arr[0], arr[1] ... ar[n-2]. If
		 * arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
		 * to be updated, then update it
		 */
		for (int i = 1; i < len; i++) {

			Data d = _lis(a, i, max_ref);
			res = d.length;
			if (a[i - 1] < a[len - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		// Compare max_ending_here with the overall max. And update the
		// overall max if needed
		// if (*max_ref < max_ending_here)
		// *max_ref = max_ending_here;
		//
		// Return length of LIS ending with arr[n-1]
		// return max_ending_here;
		return thisdata;
	}

	public static void main(String[] args) {
		Integer a[] = { 30, 45, 8, 9, 10 };
		int res = lis(a);
		System.out.println(res);
	}

	private static int lis(Integer[] a) {
		Integer maxValInLISi[] = new Integer [a.length];
		Integer lisati[] = new Integer [a.length];
		lisati[0] = 1;
		maxValInLISi[0] = a[0]; // value of new entry (if its big enuf

		for (int k = 1; k < a.length; k++) {
			int maxEligibleLISBefore = -1;
			for (int m = 0; m < k; m++) {
				if (a[k] > maxValInLISi[m]) {
					// accept a[k]
					int candidate = lisati[m];
					if (candidate > maxEligibleLISBefore) {
						maxEligibleLISBefore = candidate;
					}
					lisati[k] = 1 + maxEligibleLISBefore;
					maxValInLISi[k] = a[k];// value just accepted

				} else {
					lisati[k] = 1;
					maxValInLISi[k] = a[k];// value just accepted
				}
			}
		}

		// now we've filled up our table. Find the biggest LIS
		int res = -1;
		for (int i = 0; i < a.length; i++) {
			if (res < lisati[i]) {
				res = lisati[i];
			}
		}
		System.out.println(Arrays.asList(maxValInLISi));
		System.out.println(Arrays.asList(lisati));
		return res;
	}
}
