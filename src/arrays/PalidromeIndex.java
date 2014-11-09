package arrays;
import java.util.Scanner;

public class PalidromeIndex {

	/** return idx of char to remove. */
	private static int solve(String string) {
		int rv = -1;
		int i = 0;
		int j = string.length() - 1;
		if (string.length() == 1)
			return -1;
		if (string.length() == 2)
			return (string.charAt(0) == string.charAt(1)) ? -1 : 0;

		while (j > i) {
			if (string.charAt(i) != string.charAt(j)) {
				if (string.charAt(i + 1) == string.charAt(j)) {
					return i;
				} else if (string.charAt(j - 1) == string.charAt(i)) {
					return j;
				}
			}
			j--;
			i++;
		}

		return rv;
	}

	public static void main(String[] args) {
		
		solve("rt");
		// aa = -1
		// a
		// ceabac
		Scanner sc = new Scanner(System.in);
		int nbrTestCases = sc.nextInt();
		for (int t = 0; t < nbrTestCases; t++) {
			System.out.println(solve(sc.next()));
		}

	}

}
