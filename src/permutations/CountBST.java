package permutations;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CountBST {

	static final long big = 100000000L + 7;
	long cnt = 0;
	static long[] cache = new long[1000];

	public static void main(String[] args) {
		int nbrVertices =4;
		long start = System.nanoTime();
		long sum = cnt(nbrVertices);
		NumberFormat nf = new DecimalFormat("###,###,###,###");

		System.err.println("time: " + nf.format(System.nanoTime() - start));
		System.err.println(sum);
		System.err.println(sum % big);

	}

	private static long cnt(int n) {
		if (n == 0 || n == 1)
			return 1;
		long sum = 0;
		for (int k = 1; k <= n; k++) {
			if (cache[k - 1] == 0) {
				cache[k - 1] = cnt(k - 1);
			}
			long left = cache[k - 1];

			if (cache[n - k] == 0) {
				cache[n - k] = cnt(n - k);
			}

			long right = cache[n - k];
			;
			sum += (left * right);
		}
		return sum;
	}
}
