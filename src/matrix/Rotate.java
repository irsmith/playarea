package matrix;

public class Rotate {

	public static void main(String[] args) {
		// int a[][] = new int[4][4];
		int a[][] = new int[3][3];
		// int a[][] = new int[3][4];
		// int a[][] = new int[][11]; Cannot specify an array dimension after an empty dim
		// int a[][] = new int[1][]; //a is not null but points to null ie a[0] = null

		printRoundabout(a);
	}

	private static void printRoundabout(int[][] a) {

		if (a.length == 0)
			return;

		if (a[0] == null)
			return;

		int maxC = a[0].length;
		int maxR = a.length;
		int minC = 0;
		int minR = 0;
		int B = 0;
		for (int r = minR; r < maxR; r++) {
			for (int c = minC; c < maxC; c++) {
				a[r][c] = B++;
			}
		}

		while (true) {
			// print top
			for (int c = minC; c < maxC; c++) {
				System.out.print(a[minR][c] + " ");
			}
			// print rside
			for (int r = minR + 1; r < maxR; r++) {
				System.out.print(a[r][maxC - 1] + " ");
			}
			// print bottom
			for (int c = maxC - 2; c > minC; c--) {
				System.out.print(a[maxR - 1][c] + " ");
			}
			// print leftside
			for (int r = maxR - 1; r > minR; r--) {
				System.out.print(a[r][minC] + " ");
			}

			maxC--;
			maxR--;
			minC++;
			minR++;

			if (minR > maxR && minC > maxC)
				break;
		}
	}

}
